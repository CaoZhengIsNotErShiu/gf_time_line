package per.sc.pojo;

import lombok.Data;

/**
 * @Disc
 * @Author caozheng
 * @Date: 19/7/4 下午2:37
 * @Version 1.0
 */
@Data
public class ImageVO {
//
//    数据对象：xxxDO，xxx即为数据表名。
//    数据传输对象：xxxDTO，xxx为业务领域相关的名称。
//    展示对象：xxxVO，xxx一般为网页名称。
    /**
     * 图片路径
     */
    private String url;
}
