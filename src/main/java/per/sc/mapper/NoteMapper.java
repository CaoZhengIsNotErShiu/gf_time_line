package per.sc.mapper;

import per.sc.pojo.ArticleVO;

import java.util.List;

/**
 * Created by Administrator on 2019/11/14.
 */
public interface NoteMapper {

    /**
     * 所有note中的信息
     * @return
     */
    List<ArticleVO> allNoteInfo();
}
