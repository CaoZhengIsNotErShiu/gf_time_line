package per.sc.controller;


import org.elasticsearch.index.query.QueryBuilders;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import per.sc.pojo.ArticleInfo;
import per.sc.repository.ArticleRepository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author : zheng
 * @version : 1.0
 * @desc :
 * @date : 2020/5/11 15:15
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EsDataTest {

    @Autowired
    private ElasticsearchTemplate template;

    @Test
    public void createIndex(){
        // 创建索引，会根据Item类的@Document注解信息来创建
        template.createIndex(ArticleInfo.class);
        // 配置映射，会根据Item类中的id、Field等字段来自动完成映射
        template.putMapping(ArticleInfo.class);
    }

    @Test
    public void deleteIndex() {
        template.deleteIndex(ArticleInfo.class);
        // 根据索引名字删除
        //esTemplate.deleteIndex("item1");
    }


    @Autowired
    private ArticleRepository articleRepository;

    @Test
    public void add() {
        ArticleInfo info = new ArticleInfo();
        info.setId(2);
        info.setUserName("lisi");
        info.setTitle("钟南山说往前走还有很重的任务 年轻人会干得更好\n");
        info.setData("今天（5月11日），钟南山接援伊拉克专家回院报到时说：“我作为老职工，非常感谢你们！现在正是非常困难的时候，既要复工又要严防。9日吉林舒兰出现11个聚集病例，往前走我们还有很重的任务。我相信年轻人经过锻炼，以后都会成为骨干，很快就会比我们这些老一代干得更好！”");
        articleRepository.save(info);
    }

    @Test
    public void query() {
        Iterable<ArticleInfo> search = articleRepository.search(QueryBuilders.fuzzyQuery("title", "钟南山"));
        List<ArticleInfo> list = new ArrayList<>();
        for (ArticleInfo apiLog : search) {
            list.add(apiLog);
            System.out.println(apiLog);
        }


    }







}
