package per.sc.service;

import per.sc.pojo.ChartVO;

import java.util.List;

/**
 *
 * @author Administrator
 * @date 2019/8/23
 */
public interface ChartServiceI {

        /**
         * 过去七天发帖量
         * @return
         */
        List<ChartVO> querySevenDays();

}
