package per.sc.service;

import per.sc.pojo.ArticleVO;
import per.sc.pojo.CommentVO;

import java.util.List;

/**
 *
 * @author Administrator
 * @date 2019/8/6
 */
public interface TimeLineIndexServiceI  {

    /**
     * 获取所有用户的时间线
     * @param index 点击界面
     * @param userId 用户id
     *
     * @return
     */
    List<ArticleVO> queryAllTimeLineInfo(String index, Integer userId);



    /**
     * 插入评论
     * @param commentVO
     */
    void insertUserComment(CommentVO commentVO);

    /**
     * 根据文章id查询评论
     * @param id 文章id
     * @return
     */
    List<CommentVO> queryUserCommentByArticle(Integer id);



    /**
     * 获取所有评论及回复
     * @param offset
     * @param limit
     * @param  id
     * @return
     */
    List<CommentVO> findCommentByItemId(String id, int offset, int limit);

    /**
     * 根据评论id查询评论
     * @param id
     * @return
     */
    CommentVO queryUserCommentByCommentId(String id);

    /**
     * 根据用户id和文章id查询用户是否点赞
     * @param userId 用户id
     * @param artId 文章id
     * @return
     */
    Integer queryUserLikeNumByUserIdAndArticleId(String userId, String artId);
}
