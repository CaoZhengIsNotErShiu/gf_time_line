package per.sc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import per.sc.mapper.UserMapper;
import per.sc.pojo.UserVO;
import per.sc.pojo.dto.UserFollArtDTO;
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

    /**
     * 根据用户名查询用户id
     * @param createUser 用户名
     * @return 用户id
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String queryUserIdByUserName(String createUser) {
        return userMapper.queryUserIdByUserName(createUser);
    }

    /**
     * 根据用户名查询用户信息
     * @param userName
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserVO queryUserByName(String userName) {
        return userMapper.queryUserByName(userName);
    }

    /**
     * 查询用户文章数，关注度
     * @param userId 用户id
     * @return
     */
    @Override
    public UserFollArtDTO queryUserInfoByUserId(Integer userId, Integer loginId) {
        return userMapper.queryUserInfoByUserId(userId,loginId);
    }
}
