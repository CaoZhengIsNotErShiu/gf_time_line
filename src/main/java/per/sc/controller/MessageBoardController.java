package per.sc.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import per.sc.pojo.MessageBoard;
import per.sc.service.MessageBoardServiceI;
import per.sc.util.HttpResult;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 留言墙
 *
 * @author Administrator
 * @date 2019/11/18
 */
@RestController
@RequestMapping("mb")
public class MessageBoardController {

    private static final Logger logger = LogManager.getLogger(MessageBoardController.class);

    @Autowired
    private MessageBoardServiceI mbService;

    /**
     * 发布留言
     * @param mb
     * @return
     */
    @RequestMapping(value = "sendMess", method = RequestMethod.POST)
    public HttpResult sendMessageBoard(MessageBoard mb){
        HttpResult result = new HttpResult();
        logger.info("##1.发布留言 sendMessageBoard start ##");
        //添加留言
        try {
            mbService.sendMessageBoard(mb);
            result.setStatus(200);
        } catch (Exception e) {
            logger.error("@@ 1.发布留言 sendMessageBoard err @@",e);
            result.setStatus(500);
            result.setMsg("服务器异常 ~");
        }
        logger.info("##2.发布留言 sendMessageBoard end ##");
        return result;
    }

    /**
     * init留言
     * @param pageNum
     * @return
     */
    @RequestMapping(value = "queryMessageBoard", method = RequestMethod.POST)
    public HttpResult queryMessageBoard(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum){
        HttpResult result = new HttpResult();
        logger.info("##1.init留言 queryMessageBoard start ##");
        //查询
        try {
            PageHelper.startPage(pageNum,3);
            List<MessageBoard> lists = mbService.queryMessageBoard();
            PageInfo pageInfo = new PageInfo(lists,5);
            result.setStatus(200);
            result.setData(pageInfo);
        } catch (Exception e) {
            logger.error("@@ 1.init留言 queryMessageBoard err @@",e);
            result.setStatus(500);
            result.setMsg("服务器异常 ~");
        }
        logger.info("##2.init留言 queryMessageBoard end ##");
        return result;
    }


    /**
     * 导出留言
     * @return
     */
    @RequestMapping(value = "exportMessageBoard", method = RequestMethod.POST)
    public HttpResult exportMessageBoard(HttpServletResponse response){
        HttpResult result = new HttpResult();
        logger.info("##1.导出留言 exportMessageBoard start ##");
        //查询
        try {
            List<MessageBoard> lists = mbService.queryMessageBoard();
            List<Map<String,String>> newlist = new ArrayList<>();
            for (MessageBoard mb: lists) {
                Map<String,String> map1 = new HashMap(10);
                map1.put("id", mb.getId().toString());
                map1.put("author", mb.getAuthor());
                map1.put("text", mb.getText());
                map1.put("email", mb.getEmail());
                map1.put("createTime", mb.getCreateTime().toString());
                newlist.add(map1);
            }
            Map<String, Object> dataMap = new HashMap(10);
            dataMap.put("userList", newlist);

            Configuration configuration = new Configuration();
            configuration.setDefaultEncoding("utf-8");
            //指定模板路径的第二种方式,我的路径是D:/      还有其他方式
            //configuration.setDirectoryForTemplateLoading(new File("D:/"));
            /* 在项目中获取 */
            configuration.setClassForTemplateLoading(this.getClass(),"/model");
            // 输出文档路径及名称
            File outFile = new File("D:/mbTest.doc");
            //以utf-8的编码读取ftl文件
            Template t =  configuration.getTemplate("mbTest2.ftl","utf-8");
            //直接导出
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String fileName = URLEncoder.encode("留言墙-","UTF-8") + df.format(new Date()) +".doc";
            //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
            response.setContentType("multipart/form-data");
            //2.设置文件头：最后一个参数是设置下载文件名(假如我们叫a.pdf)
            response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);
            Writer out = new BufferedWriter(new OutputStreamWriter(response.getOutputStream(), "utf-8"),10240);
            t.process(dataMap, out);
            //导出在本地
//            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "utf-8"),10240);
//            t.process(dataMap, out);
            out.close();
            return null;
        } catch (Exception e) {
            logger.error("@@ 1.导出留言 exportMessageBoard err @@",e);
            result.setStatus(500);
            result.setMsg("服务器异常 ~");
        }
        logger.info("##2.导出留言 exportMessageBoard end ##");
        return result;
    }
}
