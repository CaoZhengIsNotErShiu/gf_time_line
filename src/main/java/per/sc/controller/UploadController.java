package per.sc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import per.sc.constant.ConstantClassField;
import per.sc.pojo.ImagePOJO;
import per.sc.pojo.TimeLinePOJO;
import per.sc.util.FileUtils;
import per.sc.util.HttpResult;

import java.io.File;
import java.io.IOException;
import java.util.UUID;


/**
 * @Disc
 * @Author caozheng
 * @Date: 19/7/4 下午1:50
 * @Version 1.0
 */
@RequestMapping("upload")
@Controller
public class UploadController {

//    @RequestMapping(value = "showLoad", method = RequestMethod.GET)
//    public String showLoad(){
//        return "html/upload";
//    }


    @RequestMapping(value = "showMsg", method = RequestMethod.GET)
    public String showMsg(){
        return "html/msg";
    }


    @RequestMapping(value = "addTimeLine", method = RequestMethod.POST)
    @ResponseBody
    public HttpResult addTimeLine(TimeLinePOJO timeLine){
        HttpResult result = new HttpResult();
        System.out.println(timeLine.toString());
        return result;
    }

    /**
     * 上传图片
     * @param file
     * @return
     */
    @RequestMapping(value = "uploadImage", method = RequestMethod.POST)
    @ResponseBody
    public HttpResult upload(@RequestParam("file") MultipartFile file){

        HttpResult result = new HttpResult();
        String path = UUID.randomUUID().toString() + ".jpg";
        ImagePOJO pojo = new ImagePOJO();
        pojo.setUrl(path);
        String filePath = ConstantClassField.UPLOAD_PATH+ path;
        if (!file.isEmpty()){
            try {
                file.transferTo(new File(filePath));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        result.setData(pojo);
        return result;
    }


    /**
     * 删除图片
     * @param path
     * @return
     */
    @RequestMapping(value = "deleteImage", method = RequestMethod.POST)
    @ResponseBody
    public HttpResult deleteImage(@RequestParam("path") String path ){
        String replace = path.replace(ConstantClassField.IMAGE_URL_PATH, "");

        String absPath = ConstantClassField.UPLOAD_PATH+ replace;
        File file = new File(absPath);
        HttpResult result = new HttpResult();
        if (!file.exists()){
            result.setStatus(500);
            result.setMsg("文件已经丢失 ~");
            return result;
        }
        FileUtils.delFile(absPath);
        result.setStatus(1);
        return result;
    }

}
