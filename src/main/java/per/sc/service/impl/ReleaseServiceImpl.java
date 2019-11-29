package per.sc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.sc.mapper.ReleaseMapper;
import per.sc.pojo.ReleaseListVO;
import per.sc.pojo.ReleaseVO;
import per.sc.service.ReleaseServiceI;

import java.util.List;

/**
 *
 * @author Administrator
 * @date 2019/11/28
 */
@Service("releaseService")
public class ReleaseServiceImpl implements ReleaseServiceI {

    @Autowired
    private ReleaseMapper releaseMapper;

    /**
     * 获取所有版本信息
     * @return
     */
    @Override
    public ReleaseListVO queryAllReleaseInfo() {
        List<String> year = releaseMapper.queryAllReleaseYear();
        List<ReleaseVO> release = releaseMapper.queryAllReleaseInfo();
        ReleaseListVO listVO = new ReleaseListVO();
        listVO.setYear(year);
        listVO.setRelList(release);
        return listVO;
    }

    /**
     * 发布版本更新信息
     * @param release
     */
    @Override
    public void addReleaseInfo(ReleaseVO release) {
        releaseMapper.addReleaseInfo(release);
    }
}
