package per.sc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import per.sc.pojo.ArticleVO;
import per.sc.result.ResultData;
import per.sc.service.UploadServiceI;
import per.sc.service.UserServiceI;
import per.sc.util.HttpResult;

/**
 *
 * @author Administrator
 * @date 2019/7/24
 */
@Slf4j
@RestController
@RequestMapping("editor")
public class EditorController {


    @Autowired
    private UploadServiceI uploadService;

//    @Autowired
//    private UserServiceI userService;


    /**
     * 上传图片
     * @param file
     * @return
     */
    @RequestMapping(value = "uploadImage", method = RequestMethod.POST)
    @ResponseBody
    public ResultData upload(@RequestParam("file") MultipartFile file){
        return uploadService.upload(file);
    }


    /**
     * 根据id查找文章
     * @param id
     * @return
     */
    @RequestMapping(value = "queryArticle", method = RequestMethod.POST)
    @ResponseBody
    public HttpResult queryArticle(@RequestParam(value="id") Integer id){
        log.info("@@1.根据id查找文章 queryArticle start @@");
        HttpResult result = new HttpResult();
        try {
            ArticleVO article  = uploadService.queryArticle(id);
//            String firstMenu = menuService.queryMenuNameByMenuId(article.getFirstMenu());
//            String subMenu = menuService.queryMenuNameByMenuId(article.getSubMenu());
//            article.setFirstMenu(firstMenu);
//            article.setSubMenu(subMenu);
            result.setStatus(200);
            result.setData(article);
        } catch (Exception e) {
            log.error("@@1.根据id查找文章 queryArticle err @@",e);
            result.setStatus(500);
            result.setMsg("查找失败 ~");
        }
        log.info("@@2.根据id查找文章 queryArticle end @@");
        return result;
    }
}
