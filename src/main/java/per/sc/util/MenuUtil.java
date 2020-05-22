package per.sc.util;

import per.sc.pojo.Menu;
import per.sc.pojo.MenuVO;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Administrator
 * @date 2019/10/18
 */
public class MenuUtil {

    public static <T>  List<T>  getChildMenus(List<T> list) {
        List<T> parentList = getParentMenus(list);
        List<T> returnList = new ArrayList();
        for (Iterator<T> iterator = parentList.iterator(); iterator.hasNext(); ) {
            T t =  iterator.next();
            // 一、根据传入的某个父节点ID,遍历该父节点的所有子节点
            recursionFn(list, t);
            returnList.add(t);
        }
        return returnList;
    }


    public static void main(String[] args) {
        List<Menu> list = new ArrayList<>();
        Menu menu = new Menu();
        menu.setMenuId(1);
        menu.setMenuText("西瓜");
        menu.setMenuParentId("0");

        Menu menu1 = new Menu();
        menu1.setMenuId(2);
        menu1.setMenuText("菠萝");
        menu1.setMenuParentId("1");
        list.add(menu);
        list.add(menu1);
        List<Menu> parentMenus = getParentMenus(list);
        for (Menu m : parentMenus) {
            System.out.println(m.toString());
        }
    }

    /**
     * 获取父节点
     *
     * @param list
     * @return
     */
    private static <T> List<T> getParentMenus(List<T> list) {
        List<T> parentList = new ArrayList();
        for (Iterator<T> iterator = list.iterator(); iterator.hasNext(); ) {
            T menu =  iterator.next();
            //统一处理公共字段
            Class<?> clazz = menu.getClass();
            String operator;
            try {
                operator = "menuParentId";
                Field fieldDate = clazz.getDeclaredField(operator);
                fieldDate.setAccessible(true);
                Object o = fieldDate.get(menu);
                if (o.equals("0")) {
                    parentList.add(menu);
                }
            } catch (NoSuchFieldException e) {
                //无此字段
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return parentList;
    }

    private static <T> void recursionFn(List<T> list, T t) {
        // 得到子节点列表
        List<T> childList = getChildList(list, t);
        //统一处理公共字段
        Class<?> clazz = t.getClass();
        String operator;
        try {
            operator = "children";
            Field fieldDate = clazz.getDeclaredField(operator);
            fieldDate.setAccessible(true);
            fieldDate.set(t,childList);
            for (T tChild : childList) {
                // 判断是否有子节点
                if (hasChild(list, tChild)) {
                    Iterator<T> it = childList.iterator();
                    while (it.hasNext()) {
                        T n = it.next();
                        recursionFn(list, n);
                    }
                }
            }
        } catch (NoSuchFieldException e) {
            //无此字段
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }



    /**
     * 得到子节点列表
     */
    private static <T> List<T> getChildList(List<T> list, T menu)  {
        List<T> menuList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            T m = it.next();
            Class<?> clazz = m.getClass();
            Field parentId = null;
            try {
                parentId = clazz.getDeclaredField("menuParentId");
                parentId.setAccessible(true);
                String pId = (String) parentId.get(m);
                Field menuId = clazz.getDeclaredField("menuId");
                menuId.setAccessible(true);
                Integer mId = (Integer) menuId.get(menu);
                if (pId.equals(Integer.toString(mId))) {
                    menuList.add(m);
                }
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return menuList;
    }

    /**
     * 判断是否有子节点
     */
    private static <T> boolean hasChild(List<T> list, T menu) {
        return getChildList(list, menu).size() > 0 ? true : false;
    }
}
