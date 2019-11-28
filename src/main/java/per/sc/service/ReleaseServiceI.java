package per.sc.service;

import per.sc.pojo.ReleaseListVO;

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
}
