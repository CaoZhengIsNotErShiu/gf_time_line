package per.sc.service;

import per.sc.pojo.ArticleVO;

import java.util.List;

/**
 *
 * @author Administrator
 * @date 2019/8/28
 */
public interface ArticleServiceI {

    /**
     * 根据用户名获取用户所有文章
     * @param userId 用户id
     * @return
     */
    List<ArticleVO> queryUserArticleByUserName(String userId);

    /**
     * 根据id查询推荐文章
     * @param id 文章id
     * @return
     */
    List<ArticleVO> queryArticleById(Integer id);

    /**
     * 根据文章id，查询文章上下两篇文章
     * @param id
     * @return
     */
    List<ArticleVO> queryNext(Integer id);
}
