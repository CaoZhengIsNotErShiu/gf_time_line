package per.sc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.sc.mapper.ChartMapper;
import per.sc.pojo.ChartVO;
import per.sc.service.ChartServiceI;

import java.util.List;

/**
 *  图表
 *
 * @author Administrator
 * @date 2019/8/23
 */
@Service("chartService")
public class ChartServiceImpl implements ChartServiceI {

    @Autowired
    private ChartMapper chartMapper;
    /**
     * 过去七天发帖量
     * @return
     */
    @Override
    public List<ChartVO> querySevenDays() {
        return chartMapper.querySevenDays();
    }
}
