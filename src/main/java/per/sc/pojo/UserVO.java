package per.sc.pojo;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Set;

/**
 *
 * @author Administrator
 * @date 2019/7/17
 */
@Data
@ToString
public class UserVO implements Serializable{

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
     * 确认密码
     */
    private String password_confirm;
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

    /**
     * 用户对应的角色集合
     */
    private Set<Role> roles;

    /**
     * 记录我
     */
    private Integer  rememberme;

}
