package per.sc.controller.entity;

/**
 * @author : zheng
 * @version : 1.0
 * @desc :
 * @date : 2020/5/11 15:52
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * indexName="索引库的名字"
 * type：表名
 * shards：分片的数量，elasticsearch自动集群，默认一个数据放6个地方
 * replicas：隐藏的一个分片
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "zch",type = "zch", shards = 1, replicas = 0)

public class zch {

    @Id
    private Long id;

    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String title; //标题

    @Field(type = FieldType.Keyword)
    private String category;// 分类

    @Field(type = FieldType.Keyword)
    private String brand; // 品牌

    @Field(type = FieldType.Double)
    private Double price; // 价格

    @Field(index = false, type = FieldType.Keyword)
    private String images; // 图片地址


}
