package per.sc.mapper;

import per.sc.pojo.ArticleVO;

import java.util.List;

/**
 * Created by Administrator on 2019/8/28.
 */
public interface ArticleMapper {

    /**
     * 根据用户名获取用户所有文章
     * @param userId
     * @return
     */
    List<ArticleVO> queryUserArticleByUserName(String userId);
}
