package per.sc.pojo;

import lombok.Data;
import lombok.ToString;

/**
 *
 * @author Administrator
 * @date 2019/7/17
 */
@Data
@ToString
public class UserVO {

    /**
     * 用户id
     */
    private String id;
    /**
     * 昵称
     */
    private String userName;
    /**
     * 密码
     */
    private String password;
    /**
     * 电话号码
     */
    private String phone;
    /**
     * 图片
     */
    private String image;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 更新时间
     */
    private String updateTime;


    /**
     * 验证码
     */
    private String code;

}
