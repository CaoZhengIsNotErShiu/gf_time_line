package per.sc.pojo;

import lombok.Data;

import java.util.List;

/**
 *
 * @author Administrator
 * @date 2019/11/28
 */
@Data
public class ReleaseListVO {
    /**
     * 年
     */
    private List<String> year;

    private List<ReleaseVO> relList;
}
