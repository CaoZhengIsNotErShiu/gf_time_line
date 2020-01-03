package per.sc.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import per.sc.annotation.SystemControllerLog;
import per.sc.pojo.ArticleVO;
import per.sc.pojo.CommentVO;
import per.sc.service.ArticleServiceI;
import per.sc.service.TimeLineIndexServiceI;
import per.sc.service.UserServiceI;
import per.sc.util.HttpResult;
import per.sc.util.RedisUtil;

import java.util.List;
import java.util.Set;


/**
 * 所有用户时间线
 * @author Administrator
 * @date 2019/7/15
 */
@Controller
@RequestMapping("timelineIndex")
public class TimeLineIndexController {

    private  static final Logger logger =
            LogManager.getLogger(TimeLineIndexController.class);

    @Autowired
    private TimeLineIndexServiceI indexService;

    @Autowired
    private UserServiceI userService;

    @Autowired
    private ArticleServiceI artService;

    @Autowired
    private RedisUtil redisUtil;



    /**
     * 获取所有用户的时间线
     * @return
     */
    @RequestMapping(value = "queryAllTimeLineInfo", method = RequestMethod.POST)
    @ResponseBody
    @SystemControllerLog(description = "获取所有用户的时间线")
    public HttpResult queryAllTimeLineInfo(String userName,String index,@RequestParam(value="pageNum",defaultValue="1")Integer pageNum){
        long start = System.currentTimeMillis();
        logger.info("## 1. 获取所有用户的时间线 queryAllTimeLineInfo start ##");
        HttpResult result = new HttpResult();
//        index =  StringUtils.isEmpty(index) ? "index" : index;
//        List<Object> lists = redisUtil.lGet("index", 1, 10);
//        if (lists.size() != 0){
//            result.setStatus(200);
//            for (Object obj: lists) {
//                result.setData(obj);
//            }
//            long end = System.currentTimeMillis();
//            System.out.println(end - start);
//            return result;
//        }

        try {
            String userId = "0";
            if(StringUtils.isNotBlank(userName)){
                 userId = userService.queryUserIdByUserName(userName);
            }
            PageHelper.startPage(pageNum,20);
            List<ArticleVO> articleVOList =  indexService.queryAllTimeLineInfo(index,Integer.valueOf(userId));

            PageInfo pageInfo = new PageInfo(articleVOList,20);
            List<ArticleVO> list = pageInfo.getList();

//            redisUtil.lSet(index,list,1000*60*60);
            List<ArticleVO> detail = artService.queryArtDetail(list, userId);
            pageInfo.setList(detail);

            result.setStatus(200);
            result.setData(pageInfo);
//            redisUtil.sSetAndTime("queryAllTimeLineInfo",1000*60,pageInfo);
        } catch (Exception e) {
            logger.error("@@ 1. 获取所有用户的时间线 queryAllTimeLineInfo err @@",e);
        }
        logger.info("## 2. 获取所有用户的时间线 queryAllTimeLineInfo end ##");
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        return result;
    }


    /**
     * 获取所有评论及回复
     * @param id 文章id
     * @return
     */
    @RequestMapping(value = "/commentAllInfo")
    @ResponseBody
    @SystemControllerLog(description = "获取所有评论及回复")
    public HttpResult commentAllInfo(String id) {
        logger.info(" ## 1.获取所有评论及回复 commentAllInfo start ##");
        HttpResult result = new HttpResult();
        List<CommentVO> itemComments = null;
        try {
            itemComments = indexService.findCommentByItemId( id,1, 10);
            result.setStatus(200);
            result.setData(itemComments);
        } catch (Exception e) {
            logger.error(" ## 1.获取所有评论及回复 commentAllInfo err ##" , e);
            result.setStatus(500);
        }
        logger.info(" ## 2.获取所有评论及回复 commentAllInfo end ##");
        return result;
    }

    /**
     * 用户评论
     * @return
     */
    @RequestMapping(value = "userComment", method = RequestMethod.POST)
    @ResponseBody
    @SystemControllerLog(description = "用户评论")
    public HttpResult userComment(CommentVO commentVO){
        logger.info("## 1. 用户评论 userComment start ##");
        HttpResult result = new HttpResult();
        try {
            //根据用户名查询用户id
            String userId =  userService.queryUserIdByUserName(commentVO.getCustomerId());
            //评论用户ID
            commentVO.setCustomerId(userId);
            //插入评论
            indexService.insertUserComment(commentVO);
            CommentVO comment =  indexService.queryUserCommentByCommentId(commentVO.getId());
            result.setStatus(200);
            result.setData(comment);
        } catch (Exception e) {
            logger.error("@@ 1. 用户评论 userComment err @@",e);
        }
        logger.info("## 2. 用户评论 userComment end ##");
        return result;
    }


    /**
     * 根据文章id查询评论
     * @return
     */
    @RequestMapping(value = "queryUserCommentByArticle", method = RequestMethod.POST)
    @ResponseBody
    @SystemControllerLog(description = "根据文章id查询评论")
    public HttpResult queryUserCommentByArticle(Integer id){
        //TODO 没用
        logger.info("## 1. 根据文章id查询评论 queryUserCommentByArticle start ##");
        HttpResult result = new HttpResult();
        try {
            List<CommentVO> comments = indexService.queryUserCommentByArticle(id);
            result.setStatus(200);
            result.setData(comments);
        } catch (Exception e) {
            logger.error("@@ 1. 根据文章id查询评论 queryUserCommentByArticle err @@",e);
        }
        logger.info("## 2. 根据文章id查询评论 queryUserCommentByArticle end ##");
        return result;
    }

//    /**
//     * 回复用户评论
//     * @return
//     */
//    @RequestMapping(value = "replyUserCommentByCommentId", method = RequestMethod.POST)
//    @ResponseBody
//    public HttpResult replyUserCommentByCommentId(CommentVO commentVO){
//        logger.info("## 1. 回复用户评论 replyUserCommentByCommentId start ##");
//        HttpResult result = new HttpResult();
//        try {
//            //根据用户名查询用户id
//            String userId =  userService.queryUserIdByUserName(commentVO.getCustomerId());
//            commentVO.setCustomerId(userId);
//            //添加评论回复
//            indexService.insertReplyUserCommentByCommentId(commentVO);
//            result.setStatus(200);
//        } catch (Exception e) {
//            logger.error("@@ 1. 回复用户评论 replyUserCommentByCommentId err @@",e);
//        }
//        logger.info("## 2. 回复用户评论 replyUserCommentByCommentId end ##");
//        return result;
//    }



}
