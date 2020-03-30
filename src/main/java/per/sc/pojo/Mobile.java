package per.sc.pojo;

import com.github.pagehelper.PageInfo;
import lombok.Data;

import java.util.List;

/**
 *
 * @author Administrator
 * @date 2020/1/6
 */
@Data
public class Mobile {

    private PageInfo listView;
    private List<ArticleVO> topImageScroll;

}
