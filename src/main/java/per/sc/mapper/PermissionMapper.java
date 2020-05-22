package per.sc.mapper;

import per.sc.pojo.Permission;
import per.sc.service.base.BaseMapper;

import java.util.List;

public interface PermissionMapper extends BaseMapper<Permission,String> {

    /**
     * 获取所有权限
     * @param id
     * @return
     */
    List<Permission> listByUserId(Integer id);
}