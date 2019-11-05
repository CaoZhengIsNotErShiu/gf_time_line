package per.sc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import per.sc.pojo.MenuVO;
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
    public HttpResult getMenu(){
        List<MenuVO>  childList ;
        HttpResult result = new HttpResult();
        List<MenuVO> lists =  menuService.getMenu();
        childList = MenuUtil.getChildMenus(lists);
        //去掉没有子菜单的列表
        Iterator<MenuVO> iter = childList.iterator();
        while(iter.hasNext()){
            MenuVO vo = iter.next();
            if(vo.getChildren().isEmpty()){
                iter.remove();
            }
        }
        result.setStatus(200);
        result.setData(childList);
        return result;
    }



}
