package per.sc.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;


/**
 * 用户评论
 *
 * @author Administrator
 * @date 2019/8/12
 */
@Data
public class CommentVO {

    /**
     * id
     */
    private String id;
    /**
     * 用户id
     */
    private String customerId;
    /**
     *  父评论id
     */
    private String parentCommentId;
    /**
     * 文章id
     */
    private String contentId;
    /**
     * // 评论内容
     */
    private String content;
    /**
     * 评论日期
     */
    private String commentDate;
    /**
     * 评论时间
     */
    @DateTimeFormat(pattern ="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date commentTime;
    /**
     * 评论的状态
     */
    private Integer state;
    /**
     * 评论类型
     */
    private Integer type;

    /**
     * 用户名
     */
    private String tempUserName;
    /**
     * 评论回复信息
     */
    private List<CommentVO> replyComment;
    /**
     * 评论者信息
     */
    private UserVO customer;
    /**
     * 回复评论的人
     */
    private UserVO replyCustomer;

}
