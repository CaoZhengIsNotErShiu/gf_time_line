package per.sc.pojo;

import lombok.ToString;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 文章表
 * @author Administrator
 */
@Document(indexName = "article_info",type = "text")
@Table(name = "article_info")
@ToString
public class ArticleInfo {

    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    @Column(name = "user_name")
    @Field(type = FieldType.Keyword)
    private String userName;

    @Column(name = "thematic_url")
    private String thematicUrl;

    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String title;

    /**
     * 一级菜单
     */
    @Column(name = "art_first_menu")
    private String artFirstMenu;

    /**
     * 二级菜单
     */
    @Column(name = "art_sub_menu")
    private String artSubMenu;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    @Field(type = FieldType.Keyword)
    private String data;

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
     * @return user_name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * @return thematic_url
     */
    public String getThematicUrl() {
        return thematicUrl;
    }

    /**
     * @param thematicUrl
     */
    public void setThematicUrl(String thematicUrl) {
        this.thematicUrl = thematicUrl == null ? null : thematicUrl.trim();
    }

    /**
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 获取一级菜单
     *
     * @return art_first_menu - 一级菜单
     */
    public String getArtFirstMenu() {
        return artFirstMenu;
    }

    /**
     * 设置一级菜单
     *
     * @param artFirstMenu 一级菜单
     */
    public void setArtFirstMenu(String artFirstMenu) {
        this.artFirstMenu = artFirstMenu == null ? null : artFirstMenu.trim();
    }

    /**
     * 获取二级菜单
     *
     * @return art_sub_menu - 二级菜单
     */
    public String getArtSubMenu() {
        return artSubMenu;
    }

    /**
     * 设置二级菜单
     *
     * @param artSubMenu 二级菜单
     */
    public void setArtSubMenu(String artSubMenu) {
        this.artSubMenu = artSubMenu == null ? null : artSubMenu.trim();
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data
     */
    public void setData(String data) {
        this.data = data == null ? null : data.trim();
    }
}