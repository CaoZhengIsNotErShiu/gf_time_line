package per.sc.pojo;

import lombok.Data;

import java.util.List;

/**
 * Created by Administrator on 2019/11/28.
 */
@Data
public class ReleaseListVO {
    /**
     * 年
     */
    private List<String> year;

    private List<ReleaseVO> relList;
}
