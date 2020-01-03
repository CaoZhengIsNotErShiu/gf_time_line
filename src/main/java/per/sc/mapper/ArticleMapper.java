package per.sc.mapper;

import per.sc.pojo.ArticleVO;

import java.util.List;

/**
 *
 * @author Administrator
 * @date 2019/8/28
 */
public interface ArticleMapper {

    /**
     * 根据用户名获取用户所有文章
     * @param userId
     * @return
     */
    List<ArticleVO> queryUserArticleByUserName(String userId);

    /**
     * 根据id查询推荐文章
     * @param id
     * @return
     */
    List<ArticleVO> queryArticleById(Integer id);

    /**
     * 根据文章id，查询文章上下两篇文章
     * @param id 文章id
     * @return
     */
    List<ArticleVO> queryNext(Integer id);

    /**
     * art
     * @return
     */
    List<ArticleVO> queryIndexInfo();

    List<ArticleVO> queryAfterInfo();

    /**
     * 查询昨天发布的文章
     * @return
     */
    List<ArticleVO> queryYesterdayArt();
}
