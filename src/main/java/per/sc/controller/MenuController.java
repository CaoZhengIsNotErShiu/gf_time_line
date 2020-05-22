package per.sc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import per.sc.pojo.Menu;
import per.sc.pojo.MenuVO;
import per.sc.result.ResultData;
import per.sc.service.MenuServiceI;
import per.sc.util.HttpResult;
import per.sc.util.MenuUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 菜单
 * @author Administrator
 * @date 2019/10/18
 */
@RestController
@RequestMapping("/menu")
public class MenuController {


    @Autowired
    private MenuServiceI menuService;

    @PostMapping("getMenu")
    public ResultData getMenu(){
        return menuService.getMenu();
    }



}
