package per.sc.mapper;

import per.sc.pojo.MenuVO;

import java.util.List;

/**
 *
 * @author Administrator
 * @date 2019/10/18
 */
public interface MenuMapper {

    /**
     * 获取所有菜单
     * @return
     */
    List<MenuVO> getMenu();

    /**
     * 根据菜单名查询菜单id
     * @param menuName
     * @return
     */
    String queryMenuIdByMenuName(String menuName);

    /**
     * 根据菜单id查询菜单名
     * @param menuId
     * @return
     */
    String queryMenuNameByMenuId(String menuId);
}
