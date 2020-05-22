package per.sc.service;

import org.springframework.web.multipart.MultipartFile;
import per.sc.pojo.ArticleVO;
import per.sc.pojo.TimeLineVO;
import per.sc.result.ResultData;

import java.util.List;

/**
 * @Disc
 * @Author caozheng
 * @Date: 19/7/9 下午7:23
 * @Version 1.0
 */
public interface UploadServiceI {

    /**
     * 发布文章
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
     *  修改文本，根据id
     * @param articleVO
     */
    void updateArticleById(ArticleVO articleVO);

    ResultData upload(MultipartFile file);
}
