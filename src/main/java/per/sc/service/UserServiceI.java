package per.sc.service;

import per.sc.pojo.Permission;
import per.sc.pojo.Role;
import per.sc.pojo.User;
import per.sc.pojo.UserVO;
import per.sc.pojo.dto.UserFollArtDTO;
import per.sc.result.ResultData;
import per.sc.service.base.BaseService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * @author Administrator
 * @date 2019/7/17
 */
public interface UserServiceI extends BaseService<User, String>{

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

    /**
     * 根据用户名查询用户id
     * @param createUser 用户名
     * @return 用户id
     */
    String queryUserIdByUserName(String createUser);

    /**
     * 根据用户名查询用户信息
     * @param userName
     * @return
     */
    UserVO queryUserByName(String userName);

    /**
     * 查询用户文章数，关注度
     * @param userId 用户id
     * @return
     */
    UserFollArtDTO queryUserInfoByUserId(Integer userId,Integer loginId);


    List<Role> findRoles(Integer id);

    List<Permission> findPermissions(Integer id);


    UserVO findUserById(String uId);

    ResultData plogin(User user, HttpServletRequest request);

    ResultData pRegister(User user, HttpSession session);

    ResultData getCode(String phone, HttpSession session);

    ResultData getUserInfo();


}
