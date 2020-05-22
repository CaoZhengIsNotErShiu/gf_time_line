package per.sc.pojo;

import javax.persistence.*;

@Table(name = "sys_role_user")
public class UserRole {
    @Id
    @Column(name = "userId")
    private Integer userid;

    @Column(name = "roleId")
    private Integer roleid;

    /**
     * @return userId
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * @param userid
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * @return roleId
     */
    public Integer getRoleid() {
        return roleid;
    }

    /**
     * @param roleid
     */
    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }
}