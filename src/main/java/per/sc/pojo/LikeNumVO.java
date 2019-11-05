package per.sc.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 *  点赞
 *
 * @author Administrator
 * @date 2019/8/21
 */
@Data
public class LikeNumVO {

    /**
     * 编号
     */
    private Integer id;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 文章id
     */
    private String articleId;
    /**
     * 点赞时间
     */
    @DateTimeFormat(pattern ="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;
}
