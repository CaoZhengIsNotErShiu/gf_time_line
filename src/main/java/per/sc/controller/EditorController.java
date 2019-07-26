package per.sc.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import per.sc.constant.ConstantClassField;
import per.sc.pojo.ArticleVO;
import per.sc.pojo.ImageVO;
import per.sc.service.UploadServiceI;
import per.sc.util.HttpResult;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 *
 * @author Administrator
 * @date 2019/7/24
 */
@Controller
@RequestMapping("editor")
public class EditorController {

    private static final Logger logger =
            LogManager.getLogger(EditorController.class);

    @Autowired
    private UploadServiceI uploadService;
    /**
     * 显示编辑页面
     * @return
     */
    @RequestMapping(value = "showEditor", method = RequestMethod.GET)
    public String showDetail(){
        return "editor/index";
    }


    /**
     * 上传图片
     * @param file
     * @return
     */
    @RequestMapping(value = "uploadImage", method = RequestMethod.POST)
    @ResponseBody
    public HttpResult upload(@RequestParam("file") MultipartFile file){
        logger.info("@@1.上传图片 uploadImage start @@");
        HttpResult result = new HttpResult();
        String path = UUID.randomUUID().toString() + ".jpg";
        String filePath = ConstantClassField.TEMP_PATH+ path;
        if (!file.isEmpty()){
            try {
                file.transferTo(new File(filePath));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        ImageVO pojo = new ImageVO();
        pojo.setUrl(ConstantClassField.IMAGE_URL_PATH+path);
        result.setData(pojo);
        logger.info("@@2.上传图片 uploadImage end @@");
        return result;
    }


    /**
     * 发布文章
     * @param data
     * @return
     */
    @RequestMapping(value = "pusArticle", method = RequestMethod.POST)
    @ResponseBody
    public HttpResult pusArticle(@RequestParam(value="data") String data){
        logger.info("@@1.发布文章 pusArticle start @@");
        HttpResult result = new HttpResult();
        ArticleVO article = new ArticleVO();
        try {
            article.setData(data);
            uploadService.pusArticle(article);
            System.out.println(article.getId());
            result.setStatus(200);
            result.setData(article.getId());
            result.setMsg("发布成功 ~");
        } catch (Exception e) {
            logger.error("@@1.发布文章 pusArticle err @@",e);
            result.setStatus(500);
            result.setMsg("发布失败 ~");
        }
        logger.info("@@2.发布文章 pusArticle end @@");
        return result;
    }
}
