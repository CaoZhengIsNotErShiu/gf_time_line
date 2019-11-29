package per.sc.mapper;

import per.sc.pojo.ReleaseVO;

import java.util.List;

/**
 *
 * @author Administrator
 * @date 2019/11/28
 */
public interface ReleaseMapper {

    /**
     * 获取所有版本信息
     * @return
     */
    List<ReleaseVO> queryAllReleaseInfo();

    /**
     * 获取所有年份信息
     * @return
     */
    List<String> queryAllReleaseYear();

    /**
     * 发布版本更新信息
     * @param release
     */
    void addReleaseInfo(ReleaseVO release);
}
