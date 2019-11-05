package per.sc.service;

import per.sc.pojo.LikeNumVO;

/**
 * 点赞
 *
 * @author Administrator
 * @date 2019/8/21
 */
public interface LikeNumServiceI {

    /**
     * 插入点赞数据信息
     * @param likeNum
     */
    void insertLikeNum(LikeNumVO likeNum);
    /**
     * 删除点赞
     * @param likeNum
     */
    void delLikeNum(LikeNumVO likeNum);

    /**
     * 查询点赞数
     * @param articleId 文章id
     * @return
     */
    Integer queryLikeNumsByArticleId(String articleId);
}
