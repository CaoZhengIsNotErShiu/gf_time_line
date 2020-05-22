package per.sc.controller;

import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import per.sc.pojo.ArticleInfo;
import per.sc.service.ArticleServiceI;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * jest 测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Jest {
    @Autowired
    JestClient jestClient;

    @Test
    public void add(){
        ArticleInfo info = new ArticleInfo();
        info.setId(1);
        info.setUserName("zhangsan");
        info.setTitle("吉林省舒兰市全面进入战时状态");
        info.setData("金华表示：\n" +
                "\n" +
                "近期，我市出现了13例本土确诊病例，打破了全省73天无本土新增病例的持续向好局面。此次疫情发生后，舒兰市委、市政府高度重视、迅速行动，立即采取有力有效措施，争分夺秒，连续昼夜组织开展相关工作，全力保障人民群众生命安全和身体健康。\n" +
                "\n" +
                "下一步，我市将深刻汲取教训，坚持举一反三，按照高等级风险防控要求，全面进入战时状态，采取最严格的管控措施，全力以赴做好疫情防控工作。\n" +
                "\n" +
                "一是全力以赴做好流调工作。把追根溯源作为当前首要任务，在国家和省市专家组的科学指导下，进一步扩大流调范围，对确诊病例、疑似病例和无症状感染者的密切接触者、次密切接触者进行全面追踪、严格排查，尽最大限度管住传染源。\n" +
                "\n" +
                "二是坚决做好隔离管控。对于排查出的存在风险人员，严格按照要求进行集中隔离医学观察，确保隔离措施严密到位，全面消除盲点。切实强化社区网格化管理、地毯式排查，对所有疫情接触者一律到隔离点进行集中隔离管控，切断传播途径，避免交叉感染。\n" +
                "\n" +
                "三是全面做好核酸检测。组织开展大排查行动，入户进行排查，发现可疑症状者立即送至定点医疗机构排查和诊治，对所有接触者、境外返回人员以及风险人群全部进行核酸检测，做到应检尽检。\n" +
                "\n" +
                "四是实行严格管控措施。建立“五位一体”包保责任制，落实网格化管理，对所有社区、村(屯)实行封闭管理。严格实行交通管制，形成县城、县域两个安全防控圈，除运输农用物资和生活物资外，其他车辆和人员严格限制通行。加强对小区、村屯、企事业单位及医院、养老院等重点部位的管控，全面进行排查,坚决不留隐患。强化门急诊预检分诊和发热门诊管理，对疑似或确诊患者按照有关规定登记、报告和隔离，及时做进一步诊断或治疗，坚决不允许患者自行转院或离院。疫情防控期间，全市所有诊所、零售药店一律停止销售治疗发热类药品，诊所不接诊发热病人。\n" +
                "\n" +
                "五是全力保障群众生活。在实行严格管控措施的同时，切实加强供水、供电、供油、市政等重点领域工作，强化生活物资保障供应，确保生活必需品供应充足和价格平稳，全力保障群众日常生活。\n" +
                "\n" +
                "我们坚信，在省委、省政府，吉林市委、市政府的正确领导下,在全市上下的共同努力下，我们一定会战胜疫情，坚决打赢疫情防控的人民战争、总体战、阻击战。");

        // 分类，类型
        Index index = new Index.Builder(info)
                .index("news")
                .type("hot")
                .build();

        try {
            jestClient.execute(index);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void query(){
        String json = "{\n" +
                "    \"query\" : {\n" +
                "        \"match\" : {\n" +
                "            \"title\" : \"状态\"\n" +
                "        }\n" +
                "    }\n" +
                "}";

        Search build = new Search.Builder(json)
                .addIndex("news")
                .addType("hot")
                .build();

        try {
            SearchResult execute = jestClient.execute(build);
            System.out.println(execute.getJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
