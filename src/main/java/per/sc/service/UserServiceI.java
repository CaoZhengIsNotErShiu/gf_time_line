package per.sc.service;

import per.sc.pojo.UserVO;

/**
 *
 * @author Administrator
 * @date 2019/7/17
 */
public interface UserServiceI {

    /**
     * 查询该号码是否被注册
     * @param phone 电话号码
     * @return 返回用户信息
     */
    UserVO checkPhone(String phone);

    /**
     * 注册用户信息
     * @param user 用户信息
     */
    void register(UserVO user);
}
