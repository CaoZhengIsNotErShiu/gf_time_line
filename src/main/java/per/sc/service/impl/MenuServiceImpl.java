package per.sc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import per.sc.mapper.MenuMapper;
import per.sc.pojo.Menu;
import per.sc.pojo.MenuVO;
import per.sc.result.ResultData;
import per.sc.service.MenuServiceI;
import per.sc.service.base.BaseMapper;
import per.sc.service.base.BaseServiceImpl;
import per.sc.util.MenuUtil;

import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Administrator
 * @date 2019/10/18
 */
@Service("menuService")
@Transactional(rollbackFor = Exception.class)
public class MenuServiceImpl extends BaseServiceImpl<Menu, String > implements MenuServiceI  {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public BaseMapper<Menu, String> getMappser() {
        return menuMapper;
    }

    @Override
    public ResultData getMenu() {
        List<Menu>  childList ;
        List<Menu> lists =  menuMapper.selectAll();
        childList = MenuUtil.getChildMenus(lists);
//        去掉没有子菜单的列表
        Iterator<Menu> iter = childList.iterator();
        while(iter.hasNext()){
            Menu vo = iter.next();
            if(vo.getChildren().isEmpty()){
                iter.remove();
            }
        }
        return ResultData.success(childList);
    }
}
