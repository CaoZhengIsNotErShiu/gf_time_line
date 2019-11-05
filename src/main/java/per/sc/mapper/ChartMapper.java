package per.sc.mapper;

import per.sc.pojo.ChartVO;

import java.util.List;

/**
 *
 * @author Administrator
 * @date 2019/8/23
 */
public interface ChartMapper {

    /**
     * 过去七天发帖量
     * @return
     */
    List<ChartVO> querySevenDays();
}
