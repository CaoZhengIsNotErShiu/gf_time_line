$(function(){
	var tab = 'account_number';

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

	$('#tel').keyup(function(event) {
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
		$(".lang-btn").off('click');
			var phone = $.trim($('#tel').val());
			var code2 = $.trim($('#veri-code').val());
			if (phone != '' && code2 != '') {
				$(".lang-btn").removeClass("off");
				sendBtn();
			} else {
				$(".lang-btn").addClass("off");
			}
		}
	})

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
		var status = true;
		if (phone == '') {
			$('.tel-err').removeClass('hide').find("em").text('请输入手机号');
			return false;
		}
		var param = /^1[34578]\d{9}$/;
		if (!param.test(phone)) {
			// globalTip({'msg':'手机号不合法，请重新输入','setTime':3});
			$('.tel-err').removeClass('hide');
			$('.tel-err').text('手机号不合法，请重新输入');
			return false;
		}
        $.ajax({
            url: '/user/checkPhone',
            type: 'post',
            dataType: 'json',
            async: false,
            data: {phone:phone},
            success:function(data){
            	console.log(data.status)
                if (data.status == 500) {
                    $('.tel-err').addClass('hide');
                    // console.log('aa');
                    // return true;
                } else {
                    $('.tel-err').removeClass('hide').text(data.msg);
                    // console.log('bb');
					status = false;
					// return false;
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
			$(".lang-btn").click(function(){
				// var type = 'phone';
				var phone = $.trim($('#tel').val());
				var pcode = $.trim($('#veri-code').val());
				console.log(phone+pcode);
				if (checkPhone(phone) && checkPass(pcode)) {
					$.ajax({
			            url: '/user/pregister',
			            type: 'post',
			            dataType: 'json',
			            async: true,
			            data: {phone:phone,code:pcode},
			            success:function(data){
			                if (data.code == '0') {
			                	// globalTip({'msg':'登录成功!','setTime':3,'jump':true,'URL':'http://www.ui.cn'});
			                	globalTip(data.msg);
			                } else if(data.code == '1') {
			                	$(".lang-btn").off('click').addClass("off");
			                    $('.num2-err').removeClass('hide').text(data.msg);
			                    return false;
			                } else if(data.code == '2') {
			                	$(".lang-btn").off('click').addClass("off");
			                    $('.error').removeClass('hide').text(data.msg);
			                    return false;
			                }
			            },
			            error:function(){
			                
			            }
			        });
				} else {
					$(".lang-btn").off('click').addClass("off");
					// $('.tel-warn').removeClass('hide').text('登录失败');
					return false;
				}
			});
	}

	// 登录的回车事件
	$(window).keydown(function(event) {
    	if (event.keyCode == 13) {
    		$('.lang-btn').trigger('click');
    	}
    });

	$(".form-data").delegate(".send","click",function () {
		var phone = $.trim($('#tel').val());
		if (checkPhone(phone)) {
				$.ajax({
		            url: '/user/getCode',
		            type: 'post',
		            dataType: 'json',
		            async: true,
					data: {phone:phone},
		            success:function(data){
		                if (data.code == '0') {
		                } else {
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
		   	var tel = num-=1;
	            oEm.text(tel);
	            if(tel==0){
	                clearInterval(timer);
	                oSend.text("重新发送验证码");
				    oSend.show();
	                oEm.text("120");
	                oTime.addClass("hide");
	            }
	        },1000);
		}
    });

