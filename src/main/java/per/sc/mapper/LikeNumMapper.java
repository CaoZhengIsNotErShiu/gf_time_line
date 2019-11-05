package per.sc.mapper;

import per.sc.pojo.LikeNumVO;

/**
 * 点赞
 * @author Administrator
 * @date 2019/8/21
 */
public interface LikeNumMapper {
    /**
     * 插入点赞信息
     * @param likeNum
     */
    void insertLikeNum(LikeNumVO likeNum);

    /**
     * 删除点赞
     * @param likeNum
     */
    void delLikeNum(LikeNumVO likeNum);

    /**
     * 查询点赞数根据文章id
     * @param articleId
     * @return
     */
    Integer queryLikeNumsByArticleId(String articleId);
}
