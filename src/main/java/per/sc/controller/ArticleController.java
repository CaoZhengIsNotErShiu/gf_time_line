package per.sc.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import per.sc.pojo.ArticleVO;
import per.sc.service.ArticleServiceI;
import per.sc.service.TimeLineIndexServiceI;
import per.sc.service.UserServiceI;
import per.sc.util.HtmlToText;
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

    @Autowired
    private TimeLineIndexServiceI indexService;

    /**
     * 根据用户名获取用户所有文章
     * @return
     */
    @RequestMapping(value = "queryUserArticleByUserName", method = RequestMethod.POST)
    public HttpResult queryUserArticleByUserName(String userName,@RequestParam(value="pageNum",defaultValue="1")Integer pageNum){
        logger.info("## 1. 根据用户名获取用户所有文章 queryUserArticleByUserName start ##");
        HttpResult result = new HttpResult();
        try {
            if (StringUtils.isNotBlank(userName)){
                String userId = userService.queryUserIdByUserName(userName);
                //PageHelper方法 （排序字段 空格 排序方式）（注意：都是数据库中的字段，不是实体pojo的）
                String orderBy = "create_time desc";
                PageHelper.startPage(pageNum,10,orderBy);
                List<ArticleVO> articleVOList = articleService.queryUserArticleByUserName(userId);
                PageInfo pageInfo = new PageInfo(articleVOList,10);
                result.setStatus(200);
                result.setData(pageInfo);
            }

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
    public HttpResult queryArticleByKey(String key,String userName){
        logger.info("## 1. 根据关键字查询文章 queryArticleByKey start ##");
        HttpResult result = new HttpResult();
        try {
            String userId = "0";
            if(StringUtils.isNotBlank(userName)){
                userId = userService.queryUserIdByUserName(userName);
            }
            List<ArticleVO> articleVOList = null;
            if (StringUtils.isNotBlank(key)){
                articleVOList = searchData(key);
                for ( ArticleVO art : articleVOList) {
                    Integer count = indexService.queryUserLikeNumByUserIdAndArticleId(userId,art.getId());
                    //把富文本中的img拿出来做首页展示
                    List<String> data = HtmlToText.getImageSrc(art.getData());
                    if(data!=null && !data.isEmpty()){
                        //取第一张即可
                        art.setThematicUrl(data.get(0).toString());
                    }
                    //去除富文本标签，只要文本内容
                    String text = HtmlToText.StripHT(art.getData());
                    art.setData(text);
                    art.setUserLikeNum(count);
                }
            }
            result.setStatus(200);
            result.setData(articleVOList);
        } catch (Exception e) {
            logger.error("@@ 1. 根据关键字查询文章 queryArticleByKey err @@",e);
        }
        logger.info("## 2. 根据关键字查询文章 queryArticleByKey end ##");
        return result;
    }


    /**
     *  根据id查询推荐文章
     * @return
     */
    @RequestMapping(value = "queryArticleById", method = RequestMethod.POST)
    public HttpResult queryArticleById(Integer id){
        logger.info("## 1. 根据id查询推荐文章 queryArticleById start ##");
        HttpResult result = new HttpResult();
        try {
            List<ArticleVO> list =articleService.queryArticleById(id);
            result.setStatus(200);
            result.setData(list);
        } catch (Exception e) {
            logger.error("@@ 1. 根据id查询推荐文章 queryArticleById err @@",e);
        }
        logger.info("## 2. 根据id查询推荐文章 queryArticleById end ##");
        return result;
    }


    /**
     *  根据文章id，查询文章上下两篇文章
     * @return
     */
    @RequestMapping(value = "queryNext", method = RequestMethod.POST)
    public HttpResult queryNext(Integer id){
        logger.info("## 1. 根据文章id，查询文章上下两篇文章 queryNext start ##");
        HttpResult result = new HttpResult();
        try {
            List<ArticleVO> list =articleService.queryNext(id);
            result.setStatus(200);
            result.setData(list);
        } catch (Exception e) {
            logger.error("@@ 1. 根据文章id，查询文章上下两篇文章 queryNext err @@",e);
        }
        logger.info("## 2. 根据文章id，查询文章上下两篇文章 queryNext end ##");
        return result;
    }

}
