package per.sc.mapper;

import per.sc.pojo.ArticleVO;
import per.sc.pojo.TimeLineVO;

import java.util.List;

/**
 * @Disc 发布功能
 * @Author caozheng
 * @Date: 19/7/9 下午7:26
 * @Version 1.0
 */
public interface UploadMapper {

    /**
     * 添加时间线信息
     *
     * @param timeLine
     * @return
     */
     void addTimeLine(TimeLineVO timeLine);

    /**
     * 查询所有时间线
     * @return
     */
    List<TimeLineVO> queryAllTimeLineInfo();

    /**
     * 根据id查询时间线
     * @param id 时间线id
     * @return 根据id查询时间线
     */
    TimeLineVO queryTimeLineInfoById(Integer id);

    /**
     * 发表文章
     * @param article
     */
    void pusArticle(ArticleVO article);

    /**
     * 根据id查找文章
     * @param id
     * @return
     */
    ArticleVO queryArticle(Integer id);
}
