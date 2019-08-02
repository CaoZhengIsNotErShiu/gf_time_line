package per.sc.service;

import per.sc.pojo.MessageVO;

import javax.jms.JMSException;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Administrator
 * @date 2019/8/2
 */
public interface ActiveMQServiceI {

    /**
     * 获取订阅主题
     * @param messageVO
     * @return
     * @throws JMSException
     * @throws IOException
     */
    List<MessageVO> receiveTopicPersist(MessageVO messageVO) throws JMSException, IOException;

    /**
     * 发布主题
     * @param messageVO
     * @return 返回 success
     * @throws JMSException
     */
    String sendTopicPersist(MessageVO messageVO) throws JMSException;
}
