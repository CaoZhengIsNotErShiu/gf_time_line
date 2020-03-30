package per.sc.service;

import per.sc.pojo.ArticleVO;

import java.util.List;

/**
 *
 * @author Administrator
 * @date 2020/1/6
 */
public interface MobileServiceI {

    /**
     * 查询顶部轮播图
     * @param index
     * @return
     */
    List<ArticleVO> getTopImageScroll(String index);

    /**
     * 手机获取文章
     * @param index
     * @return
     */
    List<ArticleVO> getMobileListView(String index);
}
