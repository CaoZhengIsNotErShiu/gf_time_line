package per.sc.controller;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.solr.client.solrj.io.eval.IFFTEvaluator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import per.sc.annotation.SystemControllerLog;
import per.sc.pojo.MessageVO;
import per.sc.pojo.dto.UserFollArtDTO;
import per.sc.service.ActiveMQServiceI;
import per.sc.service.FollowServiceI;
import per.sc.service.UserServiceI;
import per.sc.util.HttpResult;

import java.util.List;

/**
 *  消息
 * @author Administrator
 * @date 2019/8/2
 */
@RestController
public class MessageController {


    @Autowired
    private ActiveMQServiceI sendService;

    @Autowired
    private FollowServiceI followService;

    @Autowired
    private UserServiceI userService;

    public static final Logger logger =
            LogManager.getLogger(MessageController.class);
    /**
     * 获取订阅内容
     * @return
     */
    @RequestMapping("receiveTopicPersist")
    @SystemControllerLog(description = "获取订阅内容")
    public HttpResult receiveTopicPersist(String userName) throws Exception {
        String userId = "0";
        if (StringUtils.isNotBlank(userName)){
            userId = userService.queryUserIdByUserName(userName);
        }
        List<UserFollArtDTO> follArtDTOS = followService.queryFollowByUserId(Integer.valueOf(userId));
        MessageVO messageVO = new MessageVO();
        HttpResult result = new HttpResult();
        if (null == follArtDTOS || follArtDTOS.size() ==0  ){
            result.setStatus(500);
        }else{
            String strResult = "";
            for(int i=0;i< follArtDTOS.size();i++){
                strResult+=follArtDTOS.get(i).getId()+",";
            }
            messageVO.setClientID(userId);
            messageVO.setTopicName(strResult);
            List<MessageVO> messages = sendService.receiveTopicPersist(messageVO);
            result.setStatus(200);
            result.setData(messages.size());

        }
        return result;
    }


    /**
     * 关注用户
     * @return
     */
    @RequestMapping(value = "follow", method = RequestMethod.POST)
    @ResponseBody
    @SystemControllerLog(description = "关注用户")
    public HttpResult follow(String byUserName,String followUserName) {
        logger.info("@@ 1. 关注用户 follow  start @@");
        HttpResult result = new HttpResult();
        try {
            byUserName = userService.queryUserIdByUserName(byUserName);
            followUserName = userService.queryUserIdByUserName(followUserName);
            //查询是否关注了
            Integer count = followService.queryIsFollow(byUserName,followUserName);
            if (count == 0){
                //关注用户
                followService.follow(byUserName, followUserName);
            }else{
                //取消关注
                followService.followCancel(byUserName,followUserName);
            }
            //查询是否关注了
            count = followService.queryIsFollow(byUserName,followUserName);
            result.setStatus(200);
            result.setData(count);
        } catch (Exception e) {
            result.setStatus(500);
            logger.error("@@ 1. 关注用户 follow  err @@",e);
        }
        logger.info("@@ 2. 关注用户 follow  end @@");
        return result;
    }

}
