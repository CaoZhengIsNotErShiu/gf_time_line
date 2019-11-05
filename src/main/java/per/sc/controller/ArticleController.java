package per.sc.controller;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import per.sc.pojo.ArticleVO;
import per.sc.service.ArticleServiceI;
import per.sc.service.UserServiceI;
import per.sc.util.HttpResult;

import java.util.List;

import static per.sc.util.SolrUtils.searchData;


/**
 *
 * @author Administrator
 * @date 2019/8/28
 */
@RestController
@RequestMapping("art")
public class ArticleController {

    private  static final Logger logger =
            LogManager.getLogger(ArticleController.class);

    @Autowired
    private UserServiceI userService;


    @Autowired
    private ArticleServiceI articleService;

    /**
     * 根据用户名获取用户所有文章
     * @return
     */
    @RequestMapping(value = "queryUserArticleByUserName", method = RequestMethod.POST)
    public HttpResult queryUserArticleByUserName(String userName){
        logger.info("## 1. 根据用户名获取用户所有文章 queryUserArticleByUserName start ##");
        HttpResult result = new HttpResult();
        try {
            List<ArticleVO> articleVOList = null;
            if (StringUtils.isNotBlank(userName)){
                String userId = userService.queryUserIdByUserName(userName);
                 articleVOList = articleService.queryUserArticleByUserName(userId);
            }
            result.setStatus(200);
            result.setData(articleVOList);
        } catch (Exception e) {
            logger.error("@@ 1. 根据用户名获取用户所有文章 queryUserArticleByUserName err @@",e);
        }
        logger.info("## 2. 根据用户名获取用户所有文章 queryUserArticleByUserName end ##");
        return result;
    }

    /**
     *  根据关键字查询文章
     * @return
     */
    @RequestMapping(value = "queryArticleByKey", method = RequestMethod.POST)
    public HttpResult queryArticleByKey(String key){
        logger.info("## 1. 根据关键字查询文章 queryArticleByKey start ##");
        HttpResult result = new HttpResult();
        try {
            List<ArticleVO> articleVOList = null;
            if (StringUtils.isNotBlank(key)){
                articleVOList = searchData(key);
            }
            result.setStatus(200);
            result.setData(articleVOList);
        } catch (Exception e) {
            logger.error("@@ 1. 根据关键字查询文章 queryArticleByKey err @@",e);
        }
        logger.info("## 2. 根据关键字查询文章 queryArticleByKey end ##");
        return result;
    }


}
