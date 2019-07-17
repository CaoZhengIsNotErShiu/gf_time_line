package per.sc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import per.sc.mapper.UserMapper;
import per.sc.pojo.UserVO;
import per.sc.service.UserServiceI;

/**
 *
 * @author Administrator
 * @date 2019/7/17
 */
@Service("userService")
public class UserServiceImpl implements UserServiceI {

    @Autowired
    private UserMapper userMapper;
    /**
     * 查询该号码是否被注册
     * @param phone 电话号码
     * @return 返回用户信息
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserVO checkPhone(String phone) {
        return userMapper.checkPhone(phone);
    }

    /**
     * 注册用户信息
     * @param user 用户信息
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void register(UserVO user) {
        userMapper.register(user);
    }
}
