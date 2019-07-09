package per.sc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import per.sc.mapper.UploadMapper;
import per.sc.pojo.TimeLineVO;
import per.sc.service.UploadServiceI;

import java.util.List;

/**
 * @Disc
 * @Author caozheng
 * @Date: 19/7/9 下午7:23
 * @Version 1.0
 */
@Service("uploadService")
public class UploadService implements UploadServiceI {


    @Autowired
    private UploadMapper uploadMapper;

    /**
     * 发布时间信息
     * @param timeLine
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addTimeLine(TimeLineVO timeLine) {
        uploadMapper.addTimeLine(timeLine);
    }

    /**
     * 查询所有时间线
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<TimeLineVO> queryAllTimeLineInfo() {
        return uploadMapper.queryAllTimeLineInfo();
    }
}
