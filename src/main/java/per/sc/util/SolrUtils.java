package per.sc.util;

import java.io.IOException;
import java.util.*;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrInputDocument;
import per.sc.constant.ConstantClassField;
import per.sc.pojo.ArticleVO;

import java.util.Set;
import java.util.List;

/**
 * @Author：sks
 * @Description：
 * @Date：
 */
public class SolrUtils {

    public static void main(String []args) throws SolrServerException, IOException{

        String id = "北京-报纸-电动车-资讯快报.pdf";
        Init();
        //删除
//        delIndexByID("10");
//        addIndex();

        Map<String, String> maps = new HashMap();
        maps.put("id","35");
        maps.put("title","测试更新77777");
        maps.put("data","北京");

//        update(maps);
//        updateMultiData(vo);


//        String fieldName = "title";
//        Object fieldValue = "测试Solr-更新";
//        updateSingleData("7",fieldName,fieldValue);
//
//        delIndexByID(id);

    }

    private static SolrClient solr;

    /**
     * @Author：sks
     * @Description：初始化solr客户端
     * @Date：
     */
    public static void Init(){
        solr = new HttpSolrClient.Builder(ConstantClassField.SOLR_URL_PATH).build();
    }

    /**
     * @Author：sks
     * @Description：添加索引
     * @Date：
     */
    public static void addIndex(ArticleVO article) throws SolrServerException, IOException{
        Init();

        SolrInputDocument document = new SolrInputDocument();
        document.addField("id", article.getId());
        document.addField("userName", article.getUserName());
        document.addField("thematicUrl", article.getThematicUrl());
        document.addField("title", article.getTitle());
        document.addField("data", article.getData());
        document.addField("createTime", article.getCreateTime());
        document.addField("updateTime", article.getUpdateTime());
        document.addField("comments", article.getComments());
        document.addField("likenum", article.getLikenum());
        solr.add(document);
        solr.commit();
    }

    /**
     * @Author：sks
     * @Description：更新索引中单个属性数据
     * @Date：
     * @id：索引ID
     * @fieldName：属性名称
     * @fieldValue：属性值
     */
    public static void updateSingleData(String id,String fieldName,Object fieldValue) throws SolrServerException,IOException{

        HashMap<String, Object> oper = new HashMap<String, Object>();
        oper.put("set", fieldValue);
        SolrInputDocument doc = new SolrInputDocument();
        doc.addField("id", id);
        doc.addField(fieldName, oper);
        UpdateResponse rsp = solr.add(doc);
        System.out.println("update doc id:" + id + " result:" + rsp.getStatus() + " Qtime:" + rsp.getQTime());
        UpdateResponse rspCommit = solr.commit();
        System.out.println("commit doc to index" + " result:" + rspCommit.getStatus() + " Qtime:" + rspCommit.getQTime());

    }

    /**
     * @Author：sks
     * @Description：删除指定ID的索引
     * @Date：
     * @id：索引ID
     */
    public static void delIndexByID(String id) throws SolrServerException, IOException{

        UpdateResponse ur = solr.deleteById(id);
        System.out.println(ur);

        UpdateResponse c = solr.commit();
        System.out.println(c);

    }

    /**
     * @param key 查询关键字
     * @Description：查询数据
     * @return 返回查询内容
     */
    public static List<ArticleVO> searchData(String key) throws SolrServerException,IOException {
        Init();
        //使用这个对象做查询
        //2.创建查询语句
        SolrQuery query = new SolrQuery();
        //3.设置查询条件
        query.set("q", key);
        query.set("df", "title");
        //分页，默认是分页从0开始，每页显示10行
        query.setStart(0);
        query.setRows(10);
        //开启高亮显示
        query.setHighlight(true);
        query.addHighlightField("title");
        query.setHighlightSimplePre("<font style=\"color: red;\">");
        query.setHighlightSimplePost("</font>");
        //4、执行查询
        QueryResponse queryResponse = solr.query(query);
        System.out.println(queryResponse.toString());
        //5、取高亮
        Map<String, Map<String, List<String>>> map = queryResponse.getHighlighting();

        List<ArticleVO> articleVOList = queryResponse.getBeans(ArticleVO.class);
        //6、获取文档列表
        System.out.println(articleVOList.size());
        //7、遍历查询结果
        for (ArticleVO art : articleVOList) {
            //根据key获取val
            Map<String, List<String>> map1 = map.get(art.getId());
            List<String> title = map1.get("title");
            art.setTitle(title.get(0));
        }
        return articleVOList;
    }

    /**
     * 更新Solr中的文档，Map对象中必须存在id键用于定位doc文档
     * Map中其他的键值对是修改的内容，Key<String>代表数据域名称,
     * Value<Object>代表修改值
     * @param map
     */
    public static boolean update(Map<String, Object> map) {
        Init();
        try
        {
            String id = (String)map.get("id");
            SolrInputDocument doc = new SolrInputDocument();
            doc.addField("id", id);
            for(String k:map.keySet())
            {
                //数据域Id忽略更新
                if(!"id".equals(k))
                {
                    Map map2 = new HashMap();
                    map2.put("set", map.get(k));
                    doc.addField(k, map2);
                }
            }
            solr.add(doc);
            UpdateResponse resp = solr.commit();
            if(resp.getStatus() == 0){
                return true;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

}