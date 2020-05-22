package per.sc.pojo;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Data
@ToString
@Table(name = "sys_user")
public class User  {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    private String username;

    private String password;

    private String nickname;

    @Column(name = "headImgUrl")
    private String headimgurl;

    private String phone;

    private String telephone;

    private String email;

    private Date birthday;

    private Boolean sex;

    private Integer status;

    @Column(name = "createTime")
    private Date createtime;

    @Column(name = "updateTime")
    private Date updatetime;

    private List<Permission> permissions;




}