package per.sc.pojo;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Administrator
 * @date 2019/11/28
 */
@Data
public class ReleaseVO {

    /**
     * 编号
     */
    private Integer id;
    /**
     * 年
     */
    private List<String> year;

    /**
     * 内容
     */
    private String  context;
    /**
     * 创建时间
     */
    private Date createTime;

}
