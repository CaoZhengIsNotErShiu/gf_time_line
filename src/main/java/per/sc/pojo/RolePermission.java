package per.sc.pojo;

import javax.persistence.*;

@Table(name = "sys_role_permission")
public class RolePermission {

    @Id
    @Column(name = "roleId")
    private Integer roleid;

    @Column(name = "permissionId")
    private Integer permissionid;

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

    /**
     * @return permissionId
     */
    public Integer getPermissionid() {
        return permissionid;
    }

    /**
     * @param permissionid
     */
    public void setPermissionid(Integer permissionid) {
        this.permissionid = permissionid;
    }
}