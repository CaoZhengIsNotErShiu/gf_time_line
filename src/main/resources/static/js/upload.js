$("#uploadBtn").click(function(event) {
            if($("#pic-list").css("display") == "none") {
                $("#addBtn").trigger('click');
            }
});


        var uploader = new plupload.Uploader({ // 创建实例的改造方法
            runtimes: "html5, flash, silverlight, html4", // 上传插件初始化选用方法的优先级顺序
            browse_button: "addBtn",                   // 上传按钮
            url: "/upload/uploadImage",                 // 远程上传处理地址
            flash_swf_url: "/js/plupload/Moxie.swf",       // flash文件地址
            silverlight_xap_url: "/js/plupload/Moxie.xap", // silverlight文件地址
            filters: {
                max_file_size: "10mb", // 最大上传1文件大小(格式100b, 10kb, 10mb, 1gb)
                mime_types: [ // 允许文件上传的类型
                    {title: "files", extensions: "jpg,png,gif"}
                ]
            },
            multipart_params: {}, // 文件上传附加参数
            file_data_name: "file", // 文件上传名称
            multi_selection: true,  // true: 允许一次选择多个文件（ctrl）,false: 不允许
            init: {
                FilesAdded: function(up, files) { // 文件上传前
                    var recNum = $("#pic-list").children("li").length;
                    if(recNum>=10) {
                        alert("已上传9张图片！");
                        uploader.destroy();
                        console.log("destroy");
                    } else {
                        var li = "";
                        plupload.each(files, function(file) { // 遍历文件
                            li += "<li id='"+file.id+"'><div class='progress'><span class='bar'></span><span class='percent'>上传中 0%</span></div></li>";
                            recNum += 1; 
                            if(recNum==10) return false;
                        });
                        $("#addBtn").before(li);
                        if($("#pic-list").css("display") == "none"){$("#pic-list").show();} 
                        if(recNum>=10) {
                            $("#addBtn").css("display", "none");
                        }
                        uploader.start();
                    }
                    console.log("FilesAdded");
                },
                UploadProgress: function(up, file) { // 上传中，显示进度条
                    var percent = file.percent;
                    $("#"+file.id).find('.bar').css({"width": percent+'%'});
                    $("#"+file.id).find('.percent').text("上传中 "+percent+'%');
                    console.log("progress");
                },
                FileUploaded: function(up, file, info) { // 文件上传成功时触发
                    var data = JSON.parse(info.response);
                    var ip = "http://10.233.1.34:8088/image/"+data.data.url
                    $("#"+file.id).html("<img src='"+ip+"'/><b onclick='delimg(this)'>x</b><input type='hidden' name='' value='"+ip+"'>");
                    console.log("success");
                    uploader.refresh(); // 重新渲染DOM，避免在添加按钮原位置仍会响应打开文件夹
                    var recNum = $("#pic-list").children("li").length-1;
                    var hintText = "共"+recNum+"张，还能上传"+String(9-recNum)+"张";
                    $("#hint").text(hintText);
                },
                Error: function(up, err) { // 上传出错的时候触发
                    alert("error");
                }
            }
        });

        uploader.init();
        function delimg(o) {
            console.log("delete");
            var src = $(o).prev().attr("src");
            $.post('/upload/deleteImage?path='+src, function(data) {
                /*optional stuff to do after success */
                if(data.status == 1) {
                    if ($("#pic-list").children("li").length==10) {
                        $("#addBtn").css("display", "block");
                    }
                    $(o).parent().remove();
                    var recNum = $("#pic-list").children("li").length-1;
                    var hintText = "共"+recNum+"张，还能上传"+String(9-recNum)+"张";
                    $("#hint").text(hintText);
                }
                else {
                    console.log(data);
                }
            });
        }
        function delall() {
            $("#pic-list").hide();
            $("#pic-list li").children("b").each(function(index, el) {
                delimg(el);
            });
        }