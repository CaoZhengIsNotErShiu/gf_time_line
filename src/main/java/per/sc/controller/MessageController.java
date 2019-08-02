package per.sc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import per.sc.pojo.MessageVO;
import per.sc.service.ActiveMQServiceI;

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

    /**
     * 获取订阅内容
     * @return
     */
    @RequestMapping("receiveTopicPersist")
    public String receiveTopicPersist(MessageVO messageVO) throws Exception {
        List<MessageVO> cz02 = sendService.receiveTopicPersist(messageVO);
        System.out.println(cz02.toString());
        return "receiveTopicPersist";
    }

    /**
     * 发布订阅内容
     * @return
     */
    @RequestMapping("sendTopicPersist")
    public String sendTopicPersist(MessageVO messageVO) throws Exception {

            //z主题名 发送信息的id
            sendService.sendTopicPersist(messageVO);
        return "sendTopicPersist";
    }

}
