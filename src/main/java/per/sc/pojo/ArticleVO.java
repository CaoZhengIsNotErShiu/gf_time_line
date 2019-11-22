package per.sc.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 文章信息
 * @author Administrator
 * @date 2019/7/26
 */
@Data
public class ArticleVO {

    /**
     * 文章编号
     */
    @Field("id")
    private String id;
    /**
     * 文章作者名
     */
    @Field("userName")
    private String userName;
    /**
     * 文章题图
     */
    @Field("thematicUrl")
    private String thematicUrl;
    /**
     * 文章标题
     */
    @Field("title")
    private String title;
    /**
     * 文章内容
     */
    @Field("data")
    private String data;

    /**
     * 评论数
     */
    @Field("comments")
    private Integer comments;
    /**
     * 点赞数
     */
    @Field("likenum")
    private Integer likenum;
    /**
     * 是否点赞 1：点赞 0：没点
     */
    @Field("userLikeNum")
    private Integer userLikeNum;

    /**
     * 一级菜单
     */
    @Field("firstMenu")
    private String firstMenu;
    /**
     * 二级菜单
     */
    @Field("subMenu")
    private String subMenu;
    /**
     * 用户头像
     */
    private String image;
    /**
     * 标签
     */
    private String text;
    @Field("createTime")
    @DateTimeFormat(pattern ="yyyy-MM-dd HH:mm")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm",timezone="GMT+8")
    private Date createTime;
    @Field("updateTime")
    private Date updateTime;
}
