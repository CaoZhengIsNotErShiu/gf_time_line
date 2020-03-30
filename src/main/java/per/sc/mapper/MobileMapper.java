package per.sc.mapper;

import org.apache.ibatis.annotations.Param;
import per.sc.pojo.ArticleVO;

import java.util.List;

/**
 *
 * @author Administrator
 * @date 2020/1/6
 */
public interface MobileMapper {


    /**
     * 查询顶部轮播图
     * @param index
     * @param img
     * @return
     */
    List<ArticleVO> getTopImageScroll(@Param("index") String index,@Param("img") String img);

    /**
     * 手机获取文章
     * @param index
     * @return
     */
    List<ArticleVO> getMobileListView(@Param("index") String index);

}
