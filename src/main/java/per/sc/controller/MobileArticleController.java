package per.sc.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import per.sc.pojo.ArticleVO;
import per.sc.pojo.Mobile;
import per.sc.service.MobileServiceI;

import java.util.List;

/**
 * 手机端接口
 * @author Administrator
 * @date 2020/1/6
 */
@Slf4j
@RestController
@RequestMapping("mobile")
public class MobileArticleController {


    @Autowired
    private MobileServiceI mobileServiceI;

    /**
     * 顶部轮播图
     */
    @RequestMapping(value = "getTopImageScroll", method = RequestMethod.POST)
    @ResponseBody
    public List<ArticleVO> getTopImageScroll( String index){
        log.info("## 1. 顶部轮播图 queryAllTimeLineInfo start ##");
        try {
            List<ArticleVO> articleVOList =  mobileServiceI.getTopImageScroll(index);
            log.info("## 2. 顶部轮播图 queryAllTimeLineInfo end ##");
            return articleVOList;
        } catch (Exception e) {
            log.error("@@ 1. 顶部轮播图 queryAllTimeLineInfo err @@",e);
        }
        return null;
    }

    /**
     * 获取所有用户的时间线
     * @return
     */
    @RequestMapping(value = "getMobileListView", method = RequestMethod.POST)
    @ResponseBody
    public Mobile queryAllTimeLineInfo(String index, Integer pageNum){
        log.info("## 1. 手机获取所有用户的时间线 getMobileListView start ##");
        try {
            PageHelper.startPage(pageNum,5);
            //列表数据
            List<ArticleVO> listView =  mobileServiceI.getMobileListView(index);
            PageInfo pageInfo = new PageInfo(listView,5);
            //轮播图数据
            List<ArticleVO> topImageScroll =  mobileServiceI.getTopImageScroll(index);
            //放到一起
            Mobile mobile = new Mobile();
            mobile.setListView(pageInfo);
            mobile.setTopImageScroll(topImageScroll);
            log.info("## 2. 手机获取所有用户的时间线 getMobileListView end ##");
            return mobile;
        } catch (Exception e) {
            log.error("@@ 1. 手机获取所有用户的时间线 getMobileListView err @@",e);
        }
        return null;
    }






}
