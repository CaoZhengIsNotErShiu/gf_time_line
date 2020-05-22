//package per.sc.service.impl;
//
//import com.github.pagehelper.PageHelper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import per.sc.mapper.TimeLineIndexMapper;
//import per.sc.mapper.UserMapper;
//import per.sc.pojo.ArticleVO;
//import per.sc.pojo.CommentVO;
//import per.sc.pojo.User;
//import per.sc.pojo.UserVO;
//import per.sc.service.TimeLineIndexServiceI;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// *
// * @author Administrator
// * @date 2019/8/6
// */
//@Service("indexService")
//public class TimeLineIndexServiceImpl implements TimeLineIndexServiceI {
//
//    @Autowired
//    private TimeLineIndexMapper indexMapper;
//
//    @Autowired
//    private UserMapper userMapper;
//    /**
//     * 获取所有用户的时间线
//     * @param index 点击导航 index 推荐 follow 关注 热榜 hot
//     * @param userId 用户id
//     * @return
//     */
//    @Transactional(rollbackFor = Exception.class)
//    @Override
//    public List<ArticleVO> queryAllTimeLineInfo(String index,Integer userId) {
//        return indexMapper.queryAllTimeLineInfo(index,userId);
//    }
//
//    /**
//     * 插入评论
//     * @param commentVO
//     */
//    @Transactional(rollbackFor = Exception.class)
//    @Override
//    public void insertUserComment(CommentVO commentVO) {
//       indexMapper.insertUserComment(commentVO);
//    }
//
//    /**
//     * 根据文章id查询评论
//     * @param id 文章id
//     * @return
//     */
//    @Transactional(rollbackFor = Exception.class)
//    @Override
//    public List<CommentVO> queryUserCommentByArticle(Integer id) {
//        return indexMapper.queryUserCommentByArticle(id);
//    }
//
//    /**
//     *
//     * @param offset
//     * @param limit
//     * @return
//     */
//    @Transactional(rollbackFor = Exception.class)
//    @Override
//    public List<CommentVO> findCommentByItemId(String id, int offset, int limit) {
//        PageHelper.startPage(offset, limit);
//        List<CommentVO> comments = indexMapper.findParentCommentByItemId(id);
//        for (CommentVO comment : comments) {
//            // 实例化回复的集合
//            List<CommentVO> replys = new ArrayList<CommentVO>();
//            // 设置评论的回复集合
//            comment.setReplyComment(replys);
//            // 获取评论的人的Id
//            String customerId = comment.getCustomerId();
//            // 通过评论人的Id获取评论人的信息
//            User customer = userMapper.selectByPrimaryKey(customerId);
//            // 设置评论的人的信息
//            comment.setCustomer(customer);
//            // 构建评论与回复信息
//            buildReplyComment(comment, replys, offset, limit);
//        }
//        return comments;
//    }
//
//    /**
//     * 根据评论id查询评论
//     * @param id
//     * @return
//     */
//    @Transactional(rollbackFor = Exception.class)
//    @Override
//    public CommentVO queryUserCommentByCommentId(String id) {
//        return indexMapper.queryUserCommentByCommentId(id);
//    }
//
//    /**
//     * 根据用户id和文章id查询用户是否点赞
//     * @param userId 用户id
//     * @param artId 文章id
//     * @return
//     */
//    @Override
//    public Integer queryUserLikeNumByUserIdAndArticleId(String userId, String artId) {
//        return indexMapper.queryUserLikeNumByUserIdAndArticleId(userId,artId);
//    }
//
//
//    /**
//     * 构建评论与回复评论的关系
//     *
//     * @param comment
//     * @param offset
//     * @param limit
//     */
//    private void buildReplyComment(CommentVO comment, List<CommentVO> replys, int offset, int limit) {
//        PageHelper.startPage(offset, limit);
//        // 获取评论的所有回复
//        List<CommentVO> replyComments = indexMapper.findReplyCommentByCommentId(comment.getId());
//        // 把所有的回复添加到评论实例化的回复集合中
//        replys.addAll(replyComments);
//        // 遍历回复中的回复
//        for (CommentVO c : replyComments) {
//            // 获取回复人的id
//            String customerId = c.getCustomerId();
//            // 获取回复人信息
//            UserVO replyCustomer = userMapper.queryUserIdByUserId(customerId);
//            // 获取评论人的信息
//            UserVO customer = userMapper.queryUserIdByUserId(comment.getCustomerId());
//            // 设置评论人的信息
//            c.setCustomer(customer);
//            // 设置回复人的信息
//            c.setReplyCustomer(replyCustomer);
//            // 递归调用
//            buildReplyComment(c, replys, offset, limit);
//        }
//    }
//}
