package per.sc.pojo;


import lombok.Data;
import java.util.Set;

/**
 * 角色
 * @author Administrator
 */
@Data
public class Role {

    /**
     * id
     */
    private String id;

    /**
     * 角色名
     */
    private String roleName;

    /**
     * 描述
     */
    private String desc;

    /**
     * 角色对应权限集合
     */
    private Set<Permission> permissions;
}