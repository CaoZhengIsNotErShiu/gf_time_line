package per.sc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.sc.mapper.ArticleMapper;
import per.sc.pojo.ArticleVO;
import per.sc.service.ArticleServiceI;

import java.util.List;

/**
 *
 * @author Administrator
 * @date 2019/8/28
 */
@Service("articleService")
public class ArticleServiceImpl implements ArticleServiceI {

    @Autowired
    private ArticleMapper articleMapper;

    /**
     * 根据用户名获取用户所有文章
     * @param userId 用户id
     * @return
     */
    @Override
    public List<ArticleVO> queryUserArticleByUserName(String userId) {
        return articleMapper.queryUserArticleByUserName(userId);
    }

    /**
     * 根据id查询推荐文章
     * @param id 文章id
     * @return
     */
    @Override
    public List<ArticleVO> queryArticleById(Integer id) {
        return articleMapper.queryArticleById(id);
    }

    /**
     * 根据文章id，查询文章上下两篇文章
     * @param id 文章id
     * @return
     */
    @Override
    public List<ArticleVO> queryNext(Integer id) {
        return articleMapper.queryNext(id);
    }
}
