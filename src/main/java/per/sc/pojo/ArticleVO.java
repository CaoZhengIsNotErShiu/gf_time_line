package per.sc.pojo;

import lombok.Data;

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
    private Integer id;
    /**
     * 文章作者名
     */
    private String userName;
    /**
     * 文章题图
     */
    private String thematicUrl;
    /**
     * 文章标题
     */
    private String title;
    /**
     * 文章内容
     */
    private String data;
    private String createTime;
    private String updateTime;
}
