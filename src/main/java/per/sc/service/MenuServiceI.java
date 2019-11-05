package per.sc.service;

import per.sc.pojo.MenuVO;

import java.util.List;

/**
 *
 * @author Administrator
 * @date 2019/10/18
 */
public interface MenuServiceI {

    /**
     * 获取所有菜单
     * @return
     */
    List<MenuVO> getMenu();

    /**
     * 根据菜单名查询菜单id
     * @param firstMenu
     * @return
     */
    String queryMenuIdByMenuName(String firstMenu);

    /**
     * 根据菜单id，查询菜单名
     * @param menuId
     * @return
     */
    String queryMenuNameByMenuId(String menuId);
}
