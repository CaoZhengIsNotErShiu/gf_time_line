package per.sc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import per.sc.mapper.UploadMapper;
import per.sc.pojo.ArticleVO;
import per.sc.pojo.TimeLineVO;
import per.sc.service.UploadServiceI;

import java.util.List;

/**
 * @Disc
 * @Author caozheng
 * @Date: 19/7/9 下午7:23
 * @Version 1.0
 */
@Service("uploadService")
public class UploadService implements UploadServiceI {


    @Autowired
    private UploadMapper uploadMapper;

    /**
     * 发布文章
     * @param article
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void pusArticle(ArticleVO article) {
        uploadMapper.pusArticle(article);
    }

    /**
     * 根据id查找文章
     * @param id
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ArticleVO queryArticle(Integer id) {
        return uploadMapper.queryArticle(id);
    }

    /**
     * 修改文本，根据id
     * @param articleVO
     */
    @Override
    public void updateArticleById(ArticleVO articleVO) {
        uploadMapper.updateArticleById(articleVO);
    }
}
