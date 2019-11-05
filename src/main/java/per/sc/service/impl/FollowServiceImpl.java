package per.sc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import per.sc.mapper.FollowMapper;
import per.sc.pojo.dto.UserFollArtDTO;
import per.sc.service.FollowServiceI;

import java.util.List;

/**
 * Created by Administrator on 2019/9/17.
 */
@Service("followService")
public class FollowServiceImpl implements FollowServiceI {


    @Autowired
    private FollowMapper followMapper;

    /**
     * 用户关注
     *
     * @param byUserName     被关注用户
     * @param followUserName 关注者
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void follow(String byUserName, String followUserName) {
        followMapper.follow(byUserName, followUserName);
    }

    /**
     * 查询用户是否关注了
     *
     * @param byUserName     被关注
     * @param followUserName 关注
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Integer queryIsFollow(String byUserName, String followUserName) {
        return followMapper.queryIsFollow(byUserName, followUserName);
    }

    /**
     * 取消关注
     *
     * @param byUserName
     * @param followUserName
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void followCancel(String byUserName, String followUserName) {
        followMapper.followCancel(byUserName, followUserName);
    }

    /**
     * 查询用户关注账号
     * @param userId
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public List<UserFollArtDTO> queryFollowByUserId(Integer userId) {
        return followMapper.queryFollowByUserId(userId);
    }
}
