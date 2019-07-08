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
public class TimeLinePOJO {

    private String userId;//用户id
    private String title;//标题
    private String content;//内容
    private String imageUrl;//图片路径
}
