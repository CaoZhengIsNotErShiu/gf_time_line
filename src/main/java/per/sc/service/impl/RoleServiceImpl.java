package per.sc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.sc.mapper.RoleMapper;
import per.sc.pojo.Role;
import per.sc.service.RoleService;
import per.sc.service.base.BaseMapper;
import per.sc.service.base.BaseServiceImpl;

/**
 * @author : zheng
 * @version : 1.0
 * @desc :
 * @date : 2020/5/22 14:53
 */
@Service
public class RoleServiceImpl extends BaseServiceImpl<Role,String>  implements RoleService{

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public BaseMapper<Role, String> getMappser() {
        return roleMapper;
    }
}
