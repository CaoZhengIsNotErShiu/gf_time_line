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
import per.sc.pojo.MessageVO;
import per.sc.service.ActiveMQServiceI;
import per.sc.service.MenuServiceI;
import per.sc.service.UploadServiceI;
import per.sc.service.UserServiceI;
import per.sc.util.HttpResult;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import static per.sc.util.SolrUtils.addIndex;

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

    @Autowired
    private UserServiceI userService;

    @Autowired
    private ActiveMQServiceI mqService;

    @Autowired
    private MenuServiceI menuService;
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
        String filePath = ConstantClassField.TEMP_PATH + path;

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
     * @param articleVO
     * @return
     */
    @RequestMapping(value = "pusArticle", method = RequestMethod.POST)
    @ResponseBody
    public HttpResult pusArticle(ArticleVO articleVO){
        logger.info("@@1.发布文章 pusArticle start @@");
        HttpResult result = new HttpResult();
        try {
            //查询用户id
            String userId = userService.queryUserIdByUserName(articleVO.getUserName());
            //查询菜单id
            String firstMenu = menuService.queryMenuIdByMenuName(articleVO.getFirstMenu());
            String subMenu = menuService.queryMenuIdByMenuName(articleVO.getSubMenu());
            //插入
            articleVO.setUserName(userId);
            articleVO.setFirstMenu(firstMenu);
            articleVO.setSubMenu(subMenu);

            uploadService.pusArticle(articleVO);
            Integer id = Integer.valueOf(articleVO.getId());
            //根据id获取发布的文章
            ArticleVO art = uploadService.queryArticle(id);
            //同步到solr
            addIndex(art);
            //同步到mq中去
            MessageVO messageVO = new MessageVO();
            //作者id作为主题名
            messageVO.setTopicName(userId);
            //文章id作为主题内容
            messageVO.setTopicKey(art.getId());
            mqService.sendTopicPersist(messageVO);
            result.setStatus(200);
            result.setData(articleVO.getId());
            result.setMsg("发布成功 ~");
        } catch (Exception e) {
            logger.error("@@1.发布文章 pusArticle err @@",e);
            result.setStatus(500);
            result.setMsg("发布失败 ~");
        }
        logger.info("@@2.发布文章 pusArticle end @@");
        return result;
    }



    /**
     * 根据id查找文章
     * @param id
     * @return
     */
    @RequestMapping(value = "queryArticle", method = RequestMethod.POST)
    @ResponseBody
    public HttpResult queryArticle(@RequestParam(value="id") Integer id){
        logger.info("@@1.根据id查找文章 queryArticle start @@");
        HttpResult result = new HttpResult();
        try {
            ArticleVO article  = uploadService.queryArticle(id);
            String firstMenu = menuService.queryMenuNameByMenuId(article.getFirstMenu());
            String subMenu = menuService.queryMenuNameByMenuId(article.getSubMenu());
            article.setFirstMenu(firstMenu);
            article.setSubMenu(subMenu);
            result.setStatus(200);
            result.setData(article);
        } catch (Exception e) {
            logger.error("@@1.根据id查找文章 queryArticle err @@",e);
            result.setStatus(500);
            result.setMsg("查找失败 ~");
        }
        logger.info("@@2.根据id查找文章 queryArticle end @@");
        return result;
    }
}
