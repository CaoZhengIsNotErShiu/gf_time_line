package per.sc.mapper;

import per.sc.pojo.ArticleVO;
import per.sc.pojo.TimeLineVO;

import java.util.List;

/**
 * @Disc 发布功能
 * @Author caozheng
 * @Date: 19/7/9 下午7:26
 * @Version 1.0
 */
public interface UploadMapper {



    /**
     * 发表文章
     * @param article
     */
    void pusArticle(ArticleVO article);

    /**
     * 根据id查找文章
     * @param id
     * @return
     */
    ArticleVO queryArticle(Integer id);

    /**
     * 修改文本 根据id
     * @param articleVO
     */
    void updateArticleById(ArticleVO articleVO);
}
