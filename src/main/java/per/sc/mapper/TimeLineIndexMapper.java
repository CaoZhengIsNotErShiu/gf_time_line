package per.sc.mapper;

import org.apache.ibatis.annotations.Param;
import per.sc.pojo.ArticleVO;
import per.sc.pojo.CommentVO;

import java.util.List;

/**
 *
 * @author Administrator
 * @date 2019/8/6
 */
public interface TimeLineIndexMapper {
    /**
     * 获取所有用户的时间线
     * @param index
     * @param userId
     *
     * @return
     */
    List<ArticleVO> queryAllTimeLineInfo(@Param("index") String index,@Param("userId") Integer userId);

    /**
     * 插入评论
      * @param commentVO
     *  @return
     */
    void insertUserComment(CommentVO commentVO);

    /**
     * 根据文章id查询评论
     * @param id 文章id
     * @return
     */
    List<CommentVO> queryUserCommentByArticle(Integer id);


    /**
     * 查询所有父级评论
     * @param id 文章编号
     * @return
     */
    List<CommentVO> findParentCommentByItemId(String id);

    /**
     * 查询有父级的评论
     * @param parentCommentId
     * @return
     */
    List<CommentVO> findReplyCommentByCommentId(@Param("parentCommentId") String parentCommentId);


    /**
     * 根据评论id查询评论
     * @param id
     * @return
     */
    CommentVO queryUserCommentByCommentId(String id);

    /**
     * 根据用户id和文章id查询用户是否点赞
     * @param userId 用户id
     * @param artId  文章id
     * @return
     */
    Integer queryUserLikeNumByUserIdAndArticleId(@Param("userId") String userId,
                                                 @Param("artId") String artId);
}
