package per.sc.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import per.sc.pojo.ArticleInfo;

/**
 * @author : zheng
 * @version : 1.0
 * @desc :
 * @date : 2020/5/11 15:37
 */
public interface ArticleRepository extends ElasticsearchRepository<ArticleInfo,Integer> {
}

