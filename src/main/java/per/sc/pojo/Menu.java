package per.sc.pojo;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@ToString
@Data
@Table(name = "menu_info")
public class Menu {
    /**
     * 自增长主键id
     */
    @Id
    @Column(name = "menu_id")
    private Integer menuId;

    /**
     * 资源名称
     */
    @Column(name = "menu_text")
    private String menuText;

    /**
     * 资源访问路径
     */
    @Column(name = "menu_url")
    private String menuUrl;

    /**
     * 上级目录id
     */
    @Column(name = "menu_parent_id")
    private String menuParentId;

    /**
     * 菜单等级
     */
    @Column(name = "menu_level")
    private String menuLevel;

    /**
     * 该条记录创建时间
     */
    @Column(name = "menu_create_time")
    private Date menuCreateTime;

    /**
     * 子菜单
     */
    private List<Menu> children =  new ArrayList<>();

}