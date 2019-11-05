package per.sc.pojo.dto;

import lombok.Data;

/**
 * 用户 关注数 文章数
 *
 * @author Administrator
 * @date 2019/9/18
 */
@Data
public class UserFollArtDTO {

    private Integer id;
    /**
     * 姓名
     */
    private String userName;
    /**
     * 图像
     */
    private String image;
    /**
     * 签名
     */
    private String signature;
    /**
     * 文章数
     */
    private Integer articles;
    /**
     * 关注数
     */
    private Integer follows;
    /**
     * 是否关注
     */
    private Integer isFollow;
}
