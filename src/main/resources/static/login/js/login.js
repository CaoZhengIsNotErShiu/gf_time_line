$(function(){
	var tab = 'account_number';
	// 选项卡切换
	$(".account_number").click(function () {
		$('.tel-warn').addClass('hide');
		tab = $(this).attr('class').split(' ')[0];
		checkBtn();
        $(this).addClass("on");
        $(".message").removeClass("on");
        $(".form2").addClass("hide");
        $(".form1").removeClass("hide");
    });
	// 选项卡切换
	$(".message").click(function () {
		$('.tel-warn').addClass('hide');
		tab = $(this).attr('class').split(' ')[0];
		checkBtn();
		$(this).addClass("on");
        $(".account_number").removeClass("on");
		$(".form2").removeClass("hide");
		$(".form1").addClass("hide");
		
    });

	$('#num').keyup(function(event) {
		$('.tel-warn').addClass('hide');
		checkBtn();
	});

	$('#pass').keyup(function(event) {
		$('.tel-warn').addClass('hide');
		checkBtn();
	});

	$('#veri').keyup(function(event) {
		$('.tel-warn').addClass('hide');
		checkBtn();
	});

	$('#num2').keyup(function(event) {
		$('.tel-warn').addClass('hide');
		checkBtn();
	});

	$('#veri-code').keyup(function(event) {
		$('.tel-warn').addClass('hide');
		checkBtn();
	});

	// 按钮是否可点击
	function checkBtn()
	{
		$(".log-btn").off('click');
		if (tab == 'account_number') {
			var inp = $.trim($('#num').val());
			var pass = $.trim($('#pass').val());
			if (inp != '' && pass != '') {
				if (!$('.code').hasClass('hide')) {
					code = $.trim($('#veri').val());
					if (code == '') {
						$(".log-btn").addClass("off");
					} else {
						$(".log-btn").removeClass("off");
						sendBtn();
					}
				} else {
					$(".log-btn").removeClass("off");
						sendBtn();
				}
			} else {
				$(".log-btn").addClass("off");
			}
		} else {
			var phone = $.trim($('#num2').val());
			var code2 = $.trim($('#veri-code').val());
			console.log(phone+code2)
			if (phone != '' && code2 != '') {
				$(".log-btn").removeClass("off");
				sendBtn();
			} else {
				$(".log-btn").addClass("off");
			}
		}
	}

	function checkAccount(username){
		if (username == '') {
			$('.num-err').removeClass('hide').find("em").text('请输入账户');
			return false;
		} else {
			$('.num-err').addClass('hide');
			return true;
		}
	}

	function checkPass(pass){
		if (pass == '') {
			$('.pass-err').removeClass('hide').text('请输入密码');
			return false;
		} else {
			$('.pass-err').addClass('hide');
			return true;
		}
	}

	function checkCode(code){
		if (code == '') {
			// $('.tel-warn').removeClass('hide').text('请输入验证码');
			return false;
		} else {
			// $('.tel-warn').addClass('hide');
			return true;
		}
	}

	function checkPhone(phone){
		console.log(phone)
		var status = true;
		if (phone == '') {
			$('.num2-err').removeClass('hide').find("em").text('请输入手机号');
			return false;
		}
		var param = /^1[34578]\d{9}$/;
		if (!param.test(phone)) {
			// globalTip({'msg':'手机号不合法，请重新输入','setTime':3});
			$('.num2-err').removeClass('hide');
			$('.num2-err').text('手机号不合法，请重新输入');
			return false;
		}
        $.ajax({
            url: '/user/checkPhone',
            type: 'post',
            dataType: 'json',
            async: false,
            data: {phone:phone},
            success:function(data){
				console.log(data)
                if (data.status == 200) {
                    $('.num2-err').addClass('hide');
                } else {
                    $('.num2-err').removeClass('hide').text(data.msg);
					status = false;
                }
            },
            error:function(){
            	status = false;
                // return false;
            }
        });
		return status;
	}

	function checkPhoneCode(pCode){
		if (pCode == '') {
			$('.error').removeClass('hide').text('请输入验证码');
			return false;
		} else {
			$('.error').addClass('hide');
			return true;
		}
	}

	// 登录点击事件
	function sendBtn(){
		if (tab == 'account_number') {
			$(".log-btn").click(function(){
				// var type = 'phone';
				var phone = $.trim($('#num').val());
				var password = $.trim($('#pass').val());
				if (checkAccount(phone) && checkPass(password)) {
					$.ajax({
			            url: '/user/dologin',
			            type: 'post',
			            dataType: 'json',
			            async: true,
			            data: {phone:phone,password:password},
			            success:function(data){
			                if (data.status == '0') {
                                window.location.href = "/timelineIndex/showIndex";
			                } else if(data.status == '2') {
			                	$(".log-btn").off('click').addClass("off");
			                    $('.pass-err').removeClass('hide').find('em').text(data.msg);
			                    $('.pass-err').find('i').attr('class', 'icon-warn').css("color","#d9585b");
			                    return false;
			                } else if(data.status == '1'){
			                	$(".log-btn").off('click').addClass("off");
			                	$('.num-err').removeClass('hide').find('em').text(data.msg);
			                	$('.num-err').find('i').attr('class', 'icon-warn').css("color","#d9585b");
			                	return false;
			                }
			            },
			            error:function(){
			                
			            }
			        });
				} else {
					return false;
				}
			});
		} else {
			//电话登录
			$(".log-btn").click(function(){
				// var type = 'phone';
				var phone = $.trim($('#num2').val());
				var pcode = $.trim($('#veri-code').val());
				if (checkPhone(phone) && checkPass(pcode)) {
					$.ajax({
			            url: '/user/plogin',
			            type: 'post',
			            dataType: 'json',
			            async: true,
			            data: {phone:phone,code:pcode},
			            success:function(data){
                            console.log(data)
                            if (data.status == '0') {
                                $("#mpanel4").show();
                                $(".log-btn").off('click').addClass("off");
                                $('#mpanel4').slideVerify({
                                    type : 2,		//类型
                                    vOffset : 5,	//误差量，根据需求自行调整
                                    vSpace : 5,	//间隔
                                    imgName : ['1.jpg', '2.jpg'],
                                    imgSize : {
                                        width: '300px',
                                        height: '150px',
                                    },
                                    blockSize : {
                                        width: '40px',
                                        height: '40px',
                                    },
                                    barSize : {
                                        width : '300px',
                                        height : '35px',
                                    },
                                    ready : function() {
                                    },
                                    success : function() {
                                        //......后续操作
                                        window.location.href = "/timelineIndex/showIndex";
                                    },
                                    error : function() {
                                        alert('开发者想问问你是不是手残~！');
                                        // $(".log-btn").show();

                                    }
                                });

			                } else if(data.status == '1') {
			                	$(".log-btn").off('click').addClass("off");
			                    $('.num2-err').removeClass('hide').text(data.msg);
			                    return false;
			                } else if(data.status == '2') {
			                	$(".log-btn").off('click').addClass("off");
			                    $('.error').removeClass('hide').text(data.msg);
			                    return false;
			                }
			            },
			            error:function(){
			                
			            }
			        });
				} else {
					$(".log-btn").off('click').addClass("off");
					// $('.tel-warn').removeClass('hide').text('登录失败');
					return false;
				}
			});
		}
	}

	// 登录的回车事件
	$(window).keydown(function(event) {
    	if (event.keyCode == 13) {
    		$('.log-btn').trigger('click');
    	}
    });


	$(".form-data").delegate(".send","click",function () {
		var phone = $.trim($('#num2').val());
		if (checkPhone(phone)) {
				$.ajax({
		            url: '/user/getCode',
		            type: 'post',
		            dataType: 'json',
		            async: true,
					data: {phone:phone},
		            success:function(data){
		                if (data.status == 0) {

		                }
		            },
		            error:function(){

		            }
		        });
	       	var oTime = $(".form-data .time"),
            oSend = $(".form-data .send"),
            num = parseInt(oTime.text()),
            oEm = $(".form-data .time em");
            $(this).hide();
            oTime.removeClass("hide");
            var timer = setInterval(function () {
		   	var num2 = num-=1;
	            oEm.text(num2);
	            if(num2==0){
	                clearInterval(timer);
	                oSend.text("重新发送验证码");
				    oSend.show();
	                oEm.text("60");
	                oTime.addClass("hide");
	            }
	        },1000);
		}
    });



});