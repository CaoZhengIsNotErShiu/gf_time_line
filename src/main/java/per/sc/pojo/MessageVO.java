package per.sc.pojo;

import lombok.Data;

/**
 *
 * @author Administrator
 * @date 2019/8/2
 */
@Data
public class MessageVO {

    /**
     * 订阅用户id
     */
    private String clientID;

    /**
     * 签收 1为签收 2为未签收
     */
    private String signIn;

    /**
     * 订阅主题名
     */
    private String topicName;

    /**
     * 订阅主题内容
     */
    private String topicKey;

}
