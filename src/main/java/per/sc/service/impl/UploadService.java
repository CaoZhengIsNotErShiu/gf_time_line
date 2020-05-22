package per.sc.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import per.sc.constant.ConstantClassField;
import per.sc.mapper.UploadMapper;
import per.sc.pojo.ArticleVO;
import per.sc.pojo.ImageVO;
import per.sc.pojo.TimeLineVO;
import per.sc.result.ResultData;
import per.sc.service.UploadServiceI;
import per.sc.util.IdWorker;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @Disc
 * @Author caozheng
 * @Date: 19/7/9 下午7:23
 * @Version 1.0
 */
@Slf4j
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



    @Override
    public ResultData upload(MultipartFile file) {
        log.info("@@1.上传图片 uploadImage start @@");
        IdWorker idWorker = new IdWorker();
        Long id = idWorker.nextId();
        String path = id + ".jpg";
        String filePath = ConstantClassField.TEMP_PATH + path;
        if (!file.isEmpty()){
            try {
                file.transferTo(new File(filePath));
            } catch (IOException e) {
                log.error("##1.上传文件 uploadImage ERR ##", e.getMessage());
                return ResultData.error(e.getMessage());
            }
        }
        ImageVO pojo = new ImageVO();
        pojo.setUrl(File.separator+"image"+File.separator+path);
        log.info("@@2.上传图片 uploadImage end @@");
        return ResultData.success(pojo);
    }
}
