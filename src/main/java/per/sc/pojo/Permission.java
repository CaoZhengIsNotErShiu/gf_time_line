package per.sc.pojo;

import javax.persistence.*;

@Table(name = "sys_permission")
public class Permission {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    @Column(name = "parentId")
    private Integer parentid;

    private String name;

    private String css;

    private String href;

    private Boolean type;

    private String permission;

    private Integer sort;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return parentId
     */
    public Integer getParentid() {
        return parentid;
    }

    /**
     * @param parentid
     */
    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return css
     */
    public String getCss() {
        return css;
    }

    /**
     * @param css
     */
    public void setCss(String css) {
        this.css = css == null ? null : css.trim();
    }

    /**
     * @return href
     */
    public String getHref() {
        return href;
    }

    /**
     * @param href
     */
    public void setHref(String href) {
        this.href = href == null ? null : href.trim();
    }

    /**
     * @return type
     */
    public Boolean getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(Boolean type) {
        this.type = type;
    }

    /**
     * @return permission
     */
    public String getPermission() {
        return permission;
    }

    /**
     * @param permission
     */
    public void setPermission(String permission) {
        this.permission = permission == null ? null : permission.trim();
    }

    /**
     * @return sort
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * @param sort
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }
}