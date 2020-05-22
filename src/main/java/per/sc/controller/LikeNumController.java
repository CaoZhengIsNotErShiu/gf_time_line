//package per.sc.controller;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//import per.sc.pojo.ArticleVO;
//import per.sc.pojo.LikeNumVO;
//import per.sc.service.LikeNumServiceI;
//import per.sc.service.TimeLineIndexServiceI;
//import per.sc.service.UserServiceI;
//import per.sc.util.HttpResult;
//
//
///**
// * 点赞功能
// *
// * @author Administrator
// * @date 2019/8/21
// */
//@Controller
//@RequestMapping("likeNum")
//public class LikeNumController {
//
//    public static final Logger logger = LogManager.getLogger(LikeNumController.class);
//
//
////    @Autowired
////    private UserServiceI userService;
//
//    @Autowired
//    private LikeNumServiceI likeNumService;
//
//    @Autowired
//    private TimeLineIndexServiceI timeLineIndexService;
//    /**
//     * 点赞功能
//     * @param likeNum
//     * @return result
//     */
//    @RequestMapping(value = "likeNum", method = RequestMethod.POST)
//    @ResponseBody
//    public HttpResult likeNum(LikeNumVO likeNum){
//        logger.info("@@1. 点赞功能 likeNum start @@");
//        HttpResult result = new HttpResult();
//        //查询用户id
//        String userId = userService.queryUserIdByUserName(likeNum.getUserName());
//        if (null != userId){
//            //查询用户是否点赞
//            Integer count =  timeLineIndexService.queryUserLikeNumByUserIdAndArticleId(userId,likeNum.getArticleId());
//            likeNum.setUserId(Integer.valueOf(userId));
//            if (count == 0){
//                //插入点赞
//                likeNumService.insertLikeNum(likeNum);
//            }else {
//                //删除点赞
//                likeNumService.delLikeNum(likeNum);
//            }
//        }
//        //查询用户是否点赞
//        Integer count1 =  timeLineIndexService.queryUserLikeNumByUserIdAndArticleId(userId,likeNum.getArticleId());
//        //查询点赞数
//        Integer likeNums = likeNumService.queryLikeNumsByArticleId(likeNum.getArticleId());
//        ArticleVO article = new ArticleVO();
//        article.setLikenum(likeNums);
//        article.setUserLikeNum(count1);
//        result.setStatus(200);
//        result.setData(article);
//        logger.info("@@2.点赞功能 likeNum end @@");
//        return result;
//    }
//}
