package per.sc.service;

import per.sc.pojo.ReleaseListVO;
import per.sc.pojo.ReleaseVO;

/**
 *
 * @author Administrator
 * @date 2019/11/28
 */
public interface ReleaseServiceI {

    /**
     * 获取所有版本信息
     * @return
     */
    ReleaseListVO queryAllReleaseInfo();

    /**
     * 发布版本更新信息
     * @param release
     */
    void addReleaseInfo(ReleaseVO release);
}
