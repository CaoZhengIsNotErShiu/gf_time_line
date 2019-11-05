package per.sc.util;

import per.sc.pojo.MenuVO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Administrator
 * @date 2019/10/18
 */
public class MenuUtil {

    public static List<MenuVO>  getChildMenus(List<MenuVO> list) {
        List<MenuVO> parentList = getParentMenus(list);
        List<MenuVO> returnList = new ArrayList();
        for (Iterator<MenuVO> iterator = parentList.iterator(); iterator.hasNext(); ) {
            MenuVO t =  iterator.next();
            // 一、根据传入的某个父节点ID,遍历该父节点的所有子节点
            recursionFn(list, t);
            returnList.add(t);
        }
        return returnList;
    }

    /**
     * 获取父节点
     *
     * @param list
     * @return
     */
    private static List<MenuVO> getParentMenus(List<MenuVO> list) {
        List<MenuVO> parentList = new ArrayList();
        for (Iterator<MenuVO> iterator = list.iterator(); iterator.hasNext(); ) {
            MenuVO menu =  iterator.next();
            if (menu.getParentId().equals("0")) {
                parentList.add(menu);
            }
        }
        return parentList;
    }

    private static void recursionFn(List<MenuVO> list, MenuVO t) {
        // 得到子节点列表
        List<MenuVO> childList = getChildList(list, t);
        t.setChildren(childList);
        for (MenuVO tChild : childList) {
            // 判断是否有子节点
            if (hasChild(list, tChild)) {
                Iterator<MenuVO> it = childList.iterator();
                while (it.hasNext()) {
                    MenuVO n = it.next();
                    recursionFn(list, n);
                }
            }
        }
    }

    /**
     * 得到子节点列表
     */
    private static List<MenuVO> getChildList(List<MenuVO> list, MenuVO menu) {
        List<MenuVO> menuList = new ArrayList();
        Iterator<MenuVO> it = list.iterator();
        while (it.hasNext()) {
            MenuVO m = it.next();
            if (m.getParentId().equals(menu.getMenuId())) {
                menuList.add(m);
            }
        }
        return menuList;
    }

    /**
     * 判断是否有子节点
     */
    private static boolean hasChild(List<MenuVO> list, MenuVO menu) {
        return getChildList(list, menu).size() > 0 ? true : false;
    }
}
