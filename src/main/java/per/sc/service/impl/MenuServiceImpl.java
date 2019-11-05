package per.sc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import per.sc.mapper.MenuMapper;
import per.sc.pojo.MenuVO;
import per.sc.service.MenuServiceI;

import java.util.List;

/**
 *
 * @author Administrator
 * @date 2019/10/18
 */
@Service("menuService")
@Transactional(rollbackFor = Exception.class)
public class MenuServiceImpl implements MenuServiceI {

    @Autowired
    private MenuMapper menuMapper;

    /**
     * 获取所有菜单
     * @return
     */
    @Override
    public List<MenuVO> getMenu() {
        return menuMapper.getMenu();
    }

    /**
     * 根据菜单名查询菜单id
     * @param menuName 菜单名
     * @return
     */
    @Override
    public String queryMenuIdByMenuName(String menuName) {
        return menuMapper.queryMenuIdByMenuName(menuName);
    }

    /**
     * 根据菜单id,查询菜单名
     * @param menuId
     * @return
     */
    @Override
    public String queryMenuNameByMenuId(String menuId) {
        return menuMapper.queryMenuNameByMenuId(menuId);
    }
}
