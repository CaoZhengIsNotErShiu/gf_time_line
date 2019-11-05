package per.sc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.sc.mapper.LikeNumMapper;
import per.sc.pojo.LikeNumVO;
import per.sc.service.LikeNumServiceI;

/**
 * 点赞
 *
 * @author Administrator
 * @date 2019/8/21
 */
@Service("likeNumService")
public class LikeNumServiceImpl implements LikeNumServiceI {

    @Autowired
    private LikeNumMapper likeNumMapper;
    /**
     * 插入点赞信息
     * @param likeNum
     */
    @Override
    public void insertLikeNum(LikeNumVO likeNum) {
        likeNumMapper.insertLikeNum(likeNum);
    }

    /**
     * 删除点赞
     * @param likeNum
     */
    @Override
    public void delLikeNum(LikeNumVO likeNum) {
        likeNumMapper.delLikeNum(likeNum);
    }

    /**
     * 查询点赞数根据文章id
     * @param articleId 文章id
     * @return
     */
    @Override
    public Integer queryLikeNumsByArticleId(String articleId) {
        return likeNumMapper.queryLikeNumsByArticleId(articleId);
    }
}
