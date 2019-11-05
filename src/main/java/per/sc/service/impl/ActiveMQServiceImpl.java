package per.sc.service.impl;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.stereotype.Service;
import per.sc.constant.ConstantClassField;
import per.sc.pojo.MessageVO;
import per.sc.service.ActiveMQServiceI;

import javax.jms.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 * @date 2019/8/2
 */
@Service("activeMQServiceImpl")
public class ActiveMQServiceImpl implements ActiveMQServiceI {

    /**
     * 接收持久化主题
     * @throws JMSException
     * @throws IOException
     */
    @Override
    public  List<MessageVO> receiveTopicPersist(MessageVO messageVO) throws JMSException, IOException {
        // 1 按照给定的url创建连接工程，这个构造器采用默认的用户名密码
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ConstantClassField.ACTIVEMQ_URL);
        // 2 通过连接工厂连接 connection  和 启动
        Connection connection = activeMQConnectionFactory.createConnection();
        //订阅用户
        connection.setClientID(messageVO.getClientID());
        // 3.createSession的第一个参数为true 为开启事务，开启事务之后必须在将消息提交，才可以在队列中看到消息
        //AUTO_ACKNOWLEDGE 自动确认
        Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
        //主题名
        Topic topic = session.createTopic(messageVO.getTopicName());
        TopicSubscriber durableSubscriber = session.createDurableSubscriber(topic, "restart..");
        //启动
        connection.start();

        List<MessageVO> messageVOS = new ArrayList<>();

        Message message = durableSubscriber.receive();
        while (null != message){
            MessageVO messageVO1 = new MessageVO();
            TextMessage textMessage = (TextMessage) message;

            messageVO1.setTopicKey(textMessage.getText());
            //签收
            if ("1".equals(messageVO.getSignIn())){
                textMessage.acknowledge();
            }
            System.out.println("收到的订阅： "+textMessage.getText()+",订阅人："+ messageVO.getClientID());
            messageVOS.add(messageVO1);

            message = durableSubscriber.receive(1000L);
        }
        durableSubscriber.close();
        session.close();
        connection.close();
        return messageVOS;
    }

    /**
     * 发送持久化主题
     * @throws JMSException
     */
    @Override
    public String sendTopicPersist(MessageVO messageVO) throws JMSException {
        // 1 按照给定的url创建连接工程，这个构造器采用默认的用户名密码
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ConstantClassField.ACTIVEMQ_URL);
        // 2 通过连接工厂连接 connection  和 启动
        Connection connection = activeMQConnectionFactory.createConnection();
        //CLIENT_ACKNOWLEDGE  手动签收
        Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);

        //主题名
        Topic topic = session.createTopic(messageVO.getTopicName());
        //5. 创建生产者
        MessageProducer producer = session.createProducer(topic);
        //开启持久化
        producer.setDeliveryMode(DeliveryMode.PERSISTENT);
        //启动
        connection.start();
        //主题内容
        TextMessage textMessage = session.createTextMessage(messageVO.getTopicKey());
        producer.send(textMessage);
        producer.close();
        session.close();
        connection.close();

        return "success";
    }
}
