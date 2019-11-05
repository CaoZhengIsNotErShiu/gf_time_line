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
}
