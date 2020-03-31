package per.sc.pojo;

import lombok.Data;

/**
 * 权限
 * @author Administrator
 * @date 2020/3/31
 */
@Data
public class Permission {
    private String id;
    private String permissionsName;

    private String desc;
}