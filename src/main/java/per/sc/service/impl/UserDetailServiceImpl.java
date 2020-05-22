package per.sc.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import per.sc.mapper.PermissionMapper;
import per.sc.mapper.UserMapper;
import per.sc.pojo.Permission;
import per.sc.pojo.User;
import per.sc.pojo.dto.LoginUser;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author : zheng
 * @version : 1.0
 * @desc : UserDetailsService接口进行用户姓名密码校验
 * @date : 2020/5/22 13:48
 */
@Slf4j
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        log.info("登陆用户输入的用户名：{}",s);
        Example example = new Example(User.class);
        User user = new User();
        user.setUsername(s);
        example.createCriteria().andEqualTo(user);

        User user1 = userMapper.selectOneByExample(example);

        userMapper.selectByExample(example);
        if (null == user1) {
            throw new AuthenticationCredentialsNotFoundException("用户名不存在");
        }

        LoginUser loginUser = new LoginUser();
        BeanUtils.copyProperties(user1, loginUser);

        List<Permission> permissions = permissionMapper.listByUserId(user1.getId());
        loginUser.setPermissions(permissions);

        return loginUser;
    }

}