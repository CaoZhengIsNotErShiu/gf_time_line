package per.sc.service;

import per.sc.pojo.ArticleInfo;
import per.sc.result.ResultData;
import per.sc.service.base.BaseService;
import per.sc.service.base.PluginPage;


/**
 *
 * @author Administrator
 * @date 2019/8/28
 */
public interface ArticleServiceI  extends BaseService<ArticleInfo,String> {

    /**
     * 获取所有文章
     * @param pluginPage
     * @return
     */
    ResultData getArtices(PluginPage<ArticleInfo> pluginPage);

    ResultData postArticle(ArticleInfo art);

    ResultData getArticeByKey(String key, String userName);

//    /**
//     * 根据用户名获取用户所有文章
//     * @param userId 用户id
//     * @return
//     */
//    List<ArticleVO> queryUserArticleByUserName(String userId);
//
//    /**
//     * 根据id查询推荐文章
//     * @param id 文章id
//     * @return
//     */
//    List<ArticleVO> queryArticleById(Integer id);
//
//    /**
//     * 根据文章id，查询文章上下两篇文章
//     * @param id
//     * @return
//     */
//    List<ArticleVO> queryNext(Integer id);
//
//    /**
//     * 查询主页数据
//     * @return
//     */
//    List<ArticleVO> queryIndexInfo();
//
//    /**
//     * 查询文章细节
//     * @param list art
//     * @param userId 用户id
//     * @return
//     */
//    List<ArticleVO> queryArtDetail(List<ArticleVO> list,String userId);
//
//    /**
//     * 查询昨天发布的文章
//     * @return
//     */
//    List<ArticleVO> queryYesterdayArt();

//    /**
//     * 查询后端文章
//     * @return
//     */
//    List<ArticleVO> queryAfterInfo();
//
//    /**
//     * 查询前端文章
//     * @return
//     */
//    List<ArticleVO> queryFrontInfo();
//
//    /**
//     * 查询笔记文章
//     * @return
//     */
//    List<ArticleVO> queryJottingInfo();
//
//    /**
//     * 查询日记文章
//     * @return
//     */
//    List<ArticleVO> queryJourInfo();
//
//    /**
//     * 查询liunx文章
//     * @return
//     */
//    List<ArticleVO> queryLiunxInfo();
//
//    /**
//     * 查询note文章
//     * @return
//     */
//    List<ArticleVO> queryNoteInfo();
//
//    /**
//     * 查询other文章
//     * @return
//     */
//    List<ArticleVO> queryOtherInfo();
//
//    /**
//     * 查询show文章
//     * @return
//     */
//    List<ArticleVO> queryShowInfo();
//
//    /**
//     * 查询technology文章
//     * @return
//     */
//    List<ArticleVO> queryTechnologyInfo();
}
