package per.sc.pojo;

import lombok.Data;

/**
 * 文章信息
 * @author Administrator
 * @date 2019/7/26
 */
@Data
public class ArticleVO {

    private Integer id;
    private String userName;
    private String data;
    private String createTime;
    private String updateTime;
}
