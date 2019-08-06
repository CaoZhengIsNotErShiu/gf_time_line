package per.sc.mapper;

import per.sc.pojo.ArticleVO;

import java.util.List;

/**
 *
 * @author Administrator
 * @date 2019/8/6
 */
public interface TimeLineIndexMapper {
    /**
     * 获取所有用户的时间线
     * @return
     */
    List<ArticleVO> queryAllTimeLineInfo();
}
