package per.sc.mapper;

import org.apache.ibatis.annotations.Param;
import per.sc.pojo.dto.UserFollArtDTO;

import java.util.List;

/**
 * 关注
 * @author Administrator
 * @date 2019/9/17
 */
public interface FollowMapper {

    /**
     * 用户关注
     * @param byUserName
     * @param followUserName
     */
    void follow(@Param("byUserName")String byUserName,
                @Param("followUserName")String followUserName);

    /**
     * 查询用户是否关注了
     * @param byUserName 被关注
     * @param followUserName 关注
     * @return
     */
    Integer queryIsFollow(@Param("byUserName") String byUserName,
                          @Param("followUserName") String followUserName);

    /**
     * 取消关注
     * @param byUserName
     * @param followUserName
     */
    void followCancel(@Param("byUserName")String byUserName,
                      @Param("followUserName")String followUserName);

    /**
     * 查询用户关注账号
     * @param userId
     * @return
     */
    List<UserFollArtDTO> queryFollowByUserId(Integer userId);
}
