package per.sc.pojo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 * @date 2019/10/18
 */
@Data
public class MenuVO {
    /**
     * 菜单编号
     */
    private String menuId;
    /**
     * 菜单名
     */
    private String menuText;
    /**
     * 菜单路径
     */
    private String menuUrl;
    /**
     * //上级菜单id
     */
    private String parentId;
    /**
     * 菜单等级
     */
    private String menuLevel;
    /**
     * 子菜单
     */
    private List<MenuVO> children =  new ArrayList<>();

    /**
     * 创建时间
     */
    private String createTime;
}
