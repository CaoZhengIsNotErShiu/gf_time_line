package per.sc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import per.sc.pojo.ArticleInfo;
import per.sc.result.ResultData;
import per.sc.service.ArticleServiceI;
import per.sc.service.UserServiceI;
import per.sc.service.base.PluginPage;


/**
 *
 * @author Administrator
 * @date 2019/8/28
 */
@Slf4j
@RestController
@RequestMapping("art")
public class ArticleController {

//    @Autowired
//    private UserServiceI userService;

    @Autowired
    private ArticleServiceI artService;

    /**
     * 获取所有用户的时间线
     * @return
     */
    @RequestMapping(value = "getArtices", method = RequestMethod.POST)
    public ResultData getArtices(@RequestBody PluginPage<ArticleInfo> pluginPage){
        return artService.getArtices(pluginPage);
    }

    /**
     * 发布文章
     * @param art
     * @return
     */
    @RequestMapping(value = "pusArticle", method = RequestMethod.POST)
    @ResponseBody
    public ResultData pusArticle(ArticleInfo art){
      return artService.postArticle(art);
    }

    /**
     *  根据关键字查询文章
     * @return
     */
    @RequestMapping(value = "getArticleByKey", method = RequestMethod.POST)
    public ResultData queryArticleByKey(String key,String userName){
        return artService.getArticeByKey(key,userName);
    }



//    /**
//     * 根据用户名获取用户所有文章 13
//     * @return
//     */
//    @RequestMapping(value = "queryUserArticleByUserName", method = RequestMethod.POST)
//    public HttpResult queryUserArticleByUserName(String userName,@RequestParam(value="pageNum",defaultValue="1")Integer pageNum){
//        log.info("## 1. 根据用户名获取用户所有文章 queryUserArticleByUserName start ##");
//        HttpResult result = new HttpResult();
//        try {
//            if (StringUtils.isNotBlank(userName)){
//                String userId = userService.queryUserIdByUserName(userName);
//                //PageHelper方法 （排序字段 空格 排序方式）（注意：都是数据库中的字段，不是实体pojo的）
//                String orderBy = "create_time desc";
//                PageHelper.startPage(pageNum,10,orderBy);
//                List<ArticleVO> articleVOList = articleService.queryUserArticleByUserName(userId);
//                PageInfo pageInfo = new PageInfo(articleVOList,10);
//                result.setStatus(200);
//                result.setData(pageInfo);
//            }
//
//        } catch (Exception e) {
//            log.error("@@ 1. 根据用户名获取用户所有文章 queryUserArticleByUserName err @@",e);
//        }
//        log.info("## 2. 根据用户名获取用户所有文章 queryUserArticleByUserName end ##");
//        return result;
//    }
//

//
//
//    /**
//     *  根据id查询推荐文章
//     * @return
//     */
//    @RequestMapping(value = "queryArticleById", method = RequestMethod.POST)
//    public HttpResult queryArticleById(Integer id){
//        log.info("## 1. 根据id查询推荐文章 queryArticleById start ##");
//        HttpResult result = new HttpResult();
//        try {
//            List<ArticleVO> list =articleService.queryArticleById(id);
//            result.setStatus(200);
//            result.setData(list);
//        } catch (Exception e) {
//            log.error("@@ 1. 根据id查询推荐文章 queryArticleById err @@",e);
//        }
//        log.info("## 2. 根据id查询推荐文章 queryArticleById end ##");
//        return result;
//    }
//
//
//    /**
//     *  根据文章id，查询文章上下两篇文章
//     * @return
//     */
//    @RequestMapping(value = "queryNext", method = RequestMethod.POST)
//    public HttpResult queryNext(Integer id){
//        log.info("## 1. 根据文章id，查询文章上下两篇文章 queryNext start ##");
//        HttpResult result = new HttpResult();
//        try {
//            List<ArticleVO> list =articleService.queryNext(id);
//            result.setStatus(200);
//            result.setData(list);
//        } catch (Exception e) {
//            log.error("@@ 1. 根据文章id，查询文章上下两篇文章 queryNext err @@",e);
//        }
//        log.info("## 2. 根据文章id，查询文章上下两篇文章 queryNext end ##");
//        return result;
//    }
//
//
//    /**
//     * 获取所有评论及回复
//     * @param id 文章id
//     * @return
//     */
//    @RequestMapping(value = "/commentAllInfo")
//    @ResponseBody
//    @SystemControllerLog(description = "获取所有评论及回复")
//    public HttpResult commentAllInfo(String id) {
//        log.info(" ## 1.获取所有评论及回复 commentAllInfo start ##");
//        HttpResult result = new HttpResult();
//        List<CommentVO> itemComments = null;
//        try {
//            itemComments = indexService.findCommentByItemId( id,1, 10);
//            result.setStatus(200);
//            result.setData(itemComments);
//        } catch (Exception e) {
//            log.error(" ## 1.获取所有评论及回复 commentAllInfo err ##" , e);
//            result.setStatus(500);
//        }
//        log.info(" ## 2.获取所有评论及回复 commentAllInfo end ##");
//        return result;
//    }
//
//    /**
//     * 用户评论
//     * @return
//     */
//    @RequestMapping(value = "userComment", method = RequestMethod.POST)
//    @ResponseBody
//    @SystemControllerLog(description = "用户评论")
//    public HttpResult userComment(CommentVO commentVO){
//        log.info("## 1. 用户评论 userComment start ##");
//        HttpResult result = new HttpResult();
//        try {
//            //根据用户名查询用户id
//            String userId =  userService.queryUserIdByUserName(commentVO.getCustomerId());
//            //评论用户ID
//            commentVO.setCustomerId(userId);
//            //插入评论
//            indexService.insertUserComment(commentVO);
//            CommentVO comment =  indexService.queryUserCommentByCommentId(commentVO.getId());
//            result.setStatus(200);
//            result.setData(comment);
//        } catch (Exception e) {
//            log.error("@@ 1. 用户评论 userComment err @@",e);
//        }
//        log.info("## 2. 用户评论 userComment end ##");
//        return result;
//    }
//
//
//    /**
//     * 根据文章id查询评论
//     * @return
//     */
//    @RequestMapping(value = "queryUserCommentByArticle", method = RequestMethod.POST)
//    @ResponseBody
//    @SystemControllerLog(description = "根据文章id查询评论")
//    public HttpResult queryUserCommentByArticle(Integer id){
//        //TODO 没用
//        log.info("## 1. 根据文章id查询评论 queryUserCommentByArticle start ##");
//        HttpResult result = new HttpResult();
//        try {
//            List<CommentVO> comments = indexService.queryUserCommentByArticle(id);
//            result.setStatus(200);
//            result.setData(comments);
//        } catch (Exception e) {
//            log.error("@@ 1. 根据文章id查询评论 queryUserCommentByArticle err @@",e);
//        }
//        log.info("## 2. 根据文章id查询评论 queryUserCommentByArticle end ##");
//        return result;
//    }
//



}
