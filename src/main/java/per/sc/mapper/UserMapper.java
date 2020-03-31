package per.sc.mapper;

import org.apache.ibatis.annotations.Param;
import per.sc.pojo.Permission;
import per.sc.pojo.Role;
import per.sc.pojo.UserVO;
import per.sc.pojo.dto.UserFollArtDTO;

import java.util.List;

/**
 *
 * @author Administrator
 * @date 2019/7/17
 */
public interface UserMapper {

    /**
     * 查询该号码是否被注册
     * @param phone 电话号码
     * @return 返回用户信息
     */
    UserVO checkPhone(String phone);

    /**
     * 注册用户信息
     *
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
     * 根据用户id查询用户信息
     * @param customerId 用户id
     * @return 用户信息
     */
    UserVO queryUserIdByUserId(String customerId);

    /**
     * 根据用户名查询用户信息
     * @param userName 用户名
     * @return
     */
    UserVO queryUserByName(String userName);

    /**
     * 查询用户文章数，关注度
     * @param userId
     * @return
     */
    UserFollArtDTO queryUserInfoByUserId(@Param("userId") Integer userId,
                                         @Param("loginId") Integer loginId);

    /**
     * 根据用户id查询所有的角色信息
     * @param id 用户id
     * @return
     */
    List<Role> getRoleByUserId(Integer id);

    /**
     * 根据用户的id查询所有权限信息
     * @param id
     * @return
     */
    List<Permission> getPermissionByUserId(Integer id);

    UserVO findUserById(String uId);
}
