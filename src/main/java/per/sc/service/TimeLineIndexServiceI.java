package per.sc.service;

import per.sc.pojo.ArticleVO;

import java.util.List;

/**
 *
 * @author Administrator
 * @date 2019/8/6
 */
public interface TimeLineIndexServiceI  {

    /**
     * 获取所有用户的时间线
     * @return
     */
    List<ArticleVO> queryAllTimeLineInfo();
}
