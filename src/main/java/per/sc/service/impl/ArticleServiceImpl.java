package per.sc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.sc.mapper.ArticleMapper;
import per.sc.mapper.TimeLineIndexMapper;
import per.sc.pojo.ArticleVO;
import per.sc.service.ArticleServiceI;
import per.sc.util.HtmlToText;

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

    /**
     * 查询art
     * @return
     */
    @Override
    public List<ArticleVO> queryIndexInfo() {
        return articleMapper.queryIndexInfo();
    }


    @Autowired
    private TimeLineIndexMapper indexMapper;

    /**
     * 查询文章细节
     * @param list art
     * @return
     */
    @Override
    public List<ArticleVO> queryArtDetail(List<ArticleVO> list,String userId) {
        for ( ArticleVO art : list) {
            Integer count = indexMapper.queryUserLikeNumByUserIdAndArticleId(userId,art.getId());
            //把富文本中的img拿出来做首页展示
            List<String> data = HtmlToText.getImageSrc(art.getData());
            if(data!=null && !data.isEmpty()){
                //取第一张即可
                art.setThematicUrl(data.get(0).toString());
            }
            //去除富文本标签，只要文本内容
            String text = HtmlToText.StripHT(art.getData());
            art.setData(text);
            art.setUserLikeNum(count);
        }
        return list;
    }

    /**
     * queryYesterdayArt
     * @return
     */
    @Override
    public List<ArticleVO> queryYesterdayArt() {
        return articleMapper.queryYesterdayArt();
    }


//    @Override
//    public List<ArticleVO> queryAfterInfo() {
//        return articleMapper.queryAfterInfo();
//    }
//
//    @Override
//    public List<ArticleVO> queryFrontInfo() {
//        return null;
//    }
//
//    @Override
//    public List<ArticleVO> queryJottingInfo() {
//        return null;
//    }
//
//    @Override
//    public List<ArticleVO> queryJourInfo() {
//        return null;
//    }
//
//    @Override
//    public List<ArticleVO> queryLiunxInfo() {
//        return null;
//    }
//
//    @Override
//    public List<ArticleVO> queryNoteInfo() {
//        return null;
//    }
//
//    @Override
//    public List<ArticleVO> queryOtherInfo() {
//        return null;
//    }
//
//    @Override
//    public List<ArticleVO> queryShowInfo() {
//        return null;
//    }
//
//    @Override
//    public List<ArticleVO> queryTechnologyInfo() {
//        return null;
//    }
}
