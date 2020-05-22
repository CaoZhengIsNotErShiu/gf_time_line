package per.sc.service.impl;

import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.sc.mapper.ArticleInfoMapper;
import per.sc.mapper.MenuMapper;
import per.sc.mapper.UserMapper;
import per.sc.pojo.ArticleInfo;
import per.sc.pojo.ArticleVO;
import per.sc.pojo.Menu;
import per.sc.pojo.User;
import per.sc.result.ResultData;
import per.sc.service.ArticleServiceI;
import per.sc.service.base.BaseMapper;
import per.sc.service.base.BaseServiceImpl;
import per.sc.service.base.PluginPage;
import per.sc.util.BeanUtil;
import per.sc.util.HtmlToText;

import java.util.List;

import static per.sc.util.SolrUtils.searchData;


/**
 *
 * @author Administrator
 * @date 2019/8/28
 */
@Slf4j
@Service
public class ArticleServiceImpl extends BaseServiceImpl<ArticleInfo, String> implements ArticleServiceI {

    @Autowired
    ArticleInfoMapper articleMapper;

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public BaseMapper<ArticleInfo, String> getMappser() {
        return articleMapper;
    }

    @Override
    public ResultData getArtices(PluginPage<ArticleInfo> pluginPage) {
        log.info("## 1. 获取所有用户的时间线 getArtices start ##");
        PageInfo pageInfo = null;
        try {
            ArticleInfo articleInfo = BeanUtil.mapToObject(pluginPage.getQueryMap(), ArticleInfo.class);
            pluginPage.setT(articleInfo);
            pageInfo = super.listPage(pluginPage);
            List<ArticleInfo> list = pageInfo.getList();

            if (list.size() != 0){
                for ( ArticleInfo art : list) {
                    //菜单名回填
                    Menu menu = menuMapper.selectByPrimaryKey(art.getArtFirstMenu());
                    art.setArtFirstMenu(menu.getMenuText());
                    Menu menu1 = menuMapper.selectByPrimaryKey(art.getArtSubMenu());
                    art.setArtSubMenu(menu1.getMenuText());

                    //把富文本中的img拿出来做首页展示
                    List<String> data = HtmlToText.getImageSrc(art.getData());
                    if(data!=null && !data.isEmpty()){
                        //取第一张即可
                        art.setThematicUrl(data.get(0).toString());
                    }
                    //去除富文本标签，只要文本内容
                    String text = HtmlToText.StripHT(art.getData());
                    art.setData(text);
                }
            }
        } catch (Exception e) {
            log.error("@@ 1. 获取所有用户的时间线 getArtices err @@",e);
            return ResultData.error(e.getMessage());
        }
        log.info("## 2. 获取所有用户的时间线 getArtices end ##");
        return ResultData.success(pageInfo);
    }

    @Override
    public ResultData postArticle(ArticleInfo art) {
        log.info("@@1.发布文章 pusArticle start @@");
        Integer id;
        try {
//            查询用户id
            String userName = art.getUserName();
            String str1=userName.substring(0, userName.indexOf("="));
            String str2=userName.substring(str1.length()+1, userName.length());
            User user = userMapper.selectByPrimaryKey(str2);
//            查询菜单id
            Menu firstMenu = menuMapper.selectByPrimaryKey(art.getArtFirstMenu());
            Menu subMenu = menuMapper.selectByPrimaryKey(art.getArtSubMenu());
            //插入
            art.setUserName(user.getId() + "");
            art.setArtFirstMenu(firstMenu.getMenuText());
            art.setArtSubMenu(subMenu.getMenuText());
            if (null != art.getId()){
                //插入
                articleMapper.insertSelective(art);
                id = art.getId();
            }else{
                //更新
                articleMapper.updateByPrimaryKeySelective(art);
                id = art.getId();
            }
        } catch (Exception e) {
            log.error("@@1.发布文章 pusArticle err @@",e);
            return ResultData.error(e.getMessage());
        }
        log.info("@@2.发布文章 pusArticle end @@");
        return ResultData.success(id);
    }

    @Override
    public ResultData getArticeByKey(String key, String userName) {
        log.info("## 1. 根据关键字查询文章 queryArticleByKey start ##");
        List<ArticleVO> articleVOList = null;
        try {
            if (StringUtils.isNotBlank(key)){
                articleVOList = searchData(key);
//                for ( ArticleVO art : articleVOList) {
//                    Integer count = indexService.queryUserLikeNumByUserIdAndArticleId(userId,art.getId());
//                    //把富文本中的img拿出来做首页展示
//                    List<String> data = HtmlToText.getImageSrc(art.getData());
//                    if(data!=null && !data.isEmpty()){
//                        //取第一张即可
//                        art.setThematicUrl(data.get(0).toString());
//                    }
//                    //去除富文本标签，只要文本内容
//                    String text = HtmlToText.StripHT(art.getData());
//                    art.setData(text);
//                    art.setUserLikeNum(count);
//                }
            }
        } catch (Exception e) {
            log.error("@@ 1. 根据关键字查询文章 queryArticleByKey err @@",e);
            return ResultData.error(e.getMessage());
        }
        log.info("## 2. 根据关键字查询文章 queryArticleByKey end ##");
        return ResultData.success(articleVOList);
    }

//    /**
//     * 根据用户名获取用户所有文章
//     * @param userId 用户id
//     * @return
//     */
//    @Override
//    public List<ArticleVO> queryUserArticleByUserName(String userId) {
//        return articleMapper.queryUserArticleByUserName(userId);
//    }
//
//    /**
//     * 根据id查询推荐文章
//     * @param id 文章id
//     * @return
//     */
//    @Override
//    public List<ArticleVO> queryArticleById(Integer id) {
//        return articleMapper.queryArticleById(id);
//    }
//
//    /**
//     * 根据文章id，查询文章上下两篇文章
//     * @param id 文章id
//     * @return
//     */
//    @Override
//    public List<ArticleVO> queryNext(Integer id) {
//        return articleMapper.queryNext(id);
//    }
//
//    /**
//     * 查询art
//     * @return
//     */
//    @Override
//    public List<ArticleVO> queryIndexInfo() {
//        return articleMapper.queryIndexInfo();
//    }




//    /**
//     * 查询文章细节
//     * @param list art
//     * @return
//     */
//    @Override
//    public List<ArticleVO> queryArtDetail(List<ArticleVO> list,String userId) {
//        for ( ArticleVO art : list) {
//            Integer count = indexMapper.queryUserLikeNumByUserIdAndArticleId(userId,art.getId());
//            //把富文本中的img拿出来做首页展示
//            List<String> data = HtmlToText.getImageSrc(art.getData());
//            if(data!=null && !data.isEmpty()){
//                //取第一张即可
//                art.setThematicUrl(data.get(0).toString());
//            }
//            //去除富文本标签，只要文本内容
//            String text = HtmlToText.StripHT(art.getData());
//            art.setData(text);
//            art.setUserLikeNum(count);
//        }
//        return list;
//    }
//
//    /**
//     * queryYesterdayArt
//     * @return
//     */
//    @Override
//    public List<ArticleVO> queryYesterdayArt() {
//        return articleMapper.queryYesterdayArt();
//    }
//
//    @Override
//    public BaseMapper<ArticleInfo,String> getMappser() {
//        return null;
//    }


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
