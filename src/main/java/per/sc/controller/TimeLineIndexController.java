package per.sc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 所有用户时间线
 * @author Administrator
 * @date 2019/7/15
 */
@Controller
@RequestMapping("timelineIndex")
public class TimeLineIndexController {

    /**
     * 获取所有用户的时间线界面
     * @return
     */
    @RequestMapping("showIndex")
    public String showIndex(){
        return "timeline/index";
    }
}
