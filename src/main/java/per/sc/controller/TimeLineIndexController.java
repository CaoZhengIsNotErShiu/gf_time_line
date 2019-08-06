package per.sc.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import per.sc.pojo.ArticleVO;
import per.sc.service.TimeLineIndexServiceI;
import per.sc.util.HttpResult;

import java.util.List;


/**
 * 所有用户时间线
 * @author Administrator
 * @date 2019/7/15
 */
@Controller
@RequestMapping("timelineIndex")
public class TimeLineIndexController {

    private  static final Logger logger =
            LogManager.getLogger(TimeLineIndexController.class);

    @Autowired
    private TimeLineIndexServiceI indexService;
    /**
     * 获取所有用户的时间线界面
     * @return
     */
    @RequestMapping("showIndex")
    public String showIndex(){
        return "timeline/index";
    }



    /**
     * 获取所有用户的时间线
     * @return
     */
    @RequestMapping(value = "queryAllTimeLineInfo", method = RequestMethod.POST)
    @ResponseBody
    public HttpResult queryAllTimeLineInfo(){
        logger.info("## 1. 获取所有用户的时间线 queryAllTimeLineInfo start ##");
        HttpResult result = new HttpResult();
        try {
            List<ArticleVO> articleVOList =  indexService.queryAllTimeLineInfo();
            result.setStatus(200);
            result.setData(articleVOList);
        } catch (Exception e) {
            logger.error("@@ 1. 获取所有用户的时间线 queryAllTimeLineInfo err @@",e);
        }
        logger.info("## 2. 获取所有用户的时间线 queryAllTimeLineInfo end ##");
        return result;
    }
}
