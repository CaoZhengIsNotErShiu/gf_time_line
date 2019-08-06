package per.sc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import per.sc.mapper.TimeLineIndexMapper;
import per.sc.pojo.ArticleVO;
import per.sc.service.TimeLineIndexServiceI;

import java.util.List;

/**
 *
 * @author Administrator
 * @date 2019/8/6
 */
@Service("indexService")
public class TimeLineIndexServiceImpl implements TimeLineIndexServiceI {

    @Autowired
    private TimeLineIndexMapper indexMapper;
    /**
     * 获取所有用户的时间线
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public List<ArticleVO> queryAllTimeLineInfo() {
        return indexMapper.queryAllTimeLineInfo();
    }
}
