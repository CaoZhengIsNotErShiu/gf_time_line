package per.sc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author cz
 * @date 2019/7/12
 */
@Controller
@RequestMapping("detail")
public class DetailController {

    /**
     * 获取阅读更多界面
     * @return 返回界面地址
     */
    @RequestMapping(value = "showDetail", method = RequestMethod.GET)
    public String showDetail(){
        return "detail/detail";
    }

    /**
     * 获取阅读更多界面
     * @return 返回界面地址
     */
    @RequestMapping(value = "showTop", method = RequestMethod.GET)
    public String showTop(){
        return "top/index";
    }
}
