package per.sc.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 留言墙
 * @author Administrator
 * @date 2019/11/18
 */
@Data
public class MessageBoard {

    /**
     * 编号
     */
    private Integer id;
    /**
     * 内容
     */
    private String text;
    /**
     * 昵称
     */
    private String author;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern ="yyyy-MM-dd HH:mm")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm",timezone="GMT+8")
    private Date createTime;

}
