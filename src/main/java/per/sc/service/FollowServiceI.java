package per.sc.service;

import per.sc.pojo.dto.UserFollArtDTO;

import java.util.List;

/**
 *
 * @author Administrator
 * @date 2019/9/17
 */
public interface FollowServiceI  {
    /**
     * 关注用户
     * @param byUserName 被关注用户
     * @param followUserName 关注者
     */
    void follow(String byUserName, String followUserName);

    /**
     * 查询用户是否关注
     * @param byUserName 被关注
     * @param followUserName 关注
     * @return
     */
    Integer queryIsFollow(String byUserName, String followUserName);

    /**
     * 取消关注
     * @param byUserName
     * @param followUserName
     */
    void followCancel(String byUserName, String followUserName);

    /**
     * 查询用户关注账号
     * @param userId
     * @return
     */
    List<UserFollArtDTO> queryFollowByUserId(Integer userId);
}
