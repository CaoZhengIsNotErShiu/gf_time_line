package per.sc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.sc.mapper.MobileMapper;
import per.sc.pojo.ArticleVO;
import per.sc.service.MobileServiceI;

import java.util.List;

/**
 *
 * @author Administrator
 * @date 2020/1/6
 */
@Service("MobileServiceImpl")
public class MobileServiceImpl implements MobileServiceI {

    @Autowired
    private MobileMapper mobileMapper;

    /**
     * 查询顶部轮播图
     * @param index
     * @return
     */
    @Override
    public List<ArticleVO> getTopImageScroll(String index) {
        String img = "img";
        return mobileMapper.getTopImageScroll(index,img);
    }

    /**
     * 手机获取文章
     * @param index
     * @return
     */
    @Override
    public List<ArticleVO> getMobileListView(String index) {
        return mobileMapper.getMobileListView(index);
    }
}
