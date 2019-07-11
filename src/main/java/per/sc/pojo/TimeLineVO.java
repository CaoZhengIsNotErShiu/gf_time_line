package per.sc.pojo;

import lombok.Data;
import lombok.ToString;


/**
 * @Disc 时间线
 * @Author caozheng
 * @Date: 19/7/8 下午3:15
 * @Version 1.0
 */
@Data
@ToString
public class TimeLineVO {

    /**
     * 编号
     */
    private Integer id;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 标题
     */
    private String title;
    /**
     * 内容
     */
    private String content;
    /**
     * 图片路径
     */
    private String imageUrl;
    /**
     * 界面图片样式
     */
    private String color;
    /**
     * 界面图片
     */
    private String picture;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 修改时间
     */
    private String updateTime;

}
