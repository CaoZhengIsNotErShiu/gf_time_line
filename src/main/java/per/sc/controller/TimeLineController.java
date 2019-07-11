package per.sc.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import per.sc.constant.ConstantClassField;
import per.sc.pojo.ImageVO;
import per.sc.pojo.TimeLineVO;
import per.sc.service.UploadServiceI;
import per.sc.util.DateUtil;
import per.sc.util.FileUtils;
import per.sc.util.HttpResult;
import per.sc.util.StrUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;


/**
 * @Disc 时间线界面接口
 * @Author caozheng
 * @Date: 19/7/4 下午1:50
 * @Version 1.0
 */
@RequestMapping("upload")
@Controller
public class TimeLineController {

    private static final Logger logger =
            LogManager.getLogger(TimeLineController.class);

    @Autowired
    private UploadServiceI uploadService;


    /**
     * 显示发布时间线界面
     * @return 返回界面
     */
    @RequestMapping(value = "showSend", method = RequestMethod.GET)
    public String showSend(){
        return "html/msg";
    }


    /**
     * 显示时间线界面
     * @return 返回界面
     */
    @RequestMapping(value = "showTimeLine", method = RequestMethod.GET)
    public String showTimeLine(){
        return "upload/index";
    }

    /**
     * 查询所有时间线
     * @param pn 当前页
     * @return 时间线结果
     */
    @RequestMapping(value = "queryAllTimeLineInfo", method = RequestMethod.GET)
    @ResponseBody
    public HttpResult queryAllTimeLineInfo(@RequestParam(value="pn",defaultValue="1")Integer pn){
        logger.info("@@1.查询所有时间线 queryAllTimeLineInfo start @@");
        HttpResult result = new HttpResult();
        PageHelper.startPage(pn,6);
        List<TimeLineVO> list = null;
        try {
            list = uploadService.queryAllTimeLineInfo();
        } catch (Exception e) {
            logger.error("## 1.查询所有时间线 queryAllTimeLineInfo err##",e);
        }
        PageInfo pageInfo = new PageInfo(list,6);
        if (CollectionUtils.isNotEmpty(list)){
            result.setStatus(200);
            result.setData(pageInfo);
        }
        logger.info("@@2.查询所有时间线 queryAllTimeLineInfo end @@");
        return result;
    }

    /**
     * 发布时间线
     * @param timeLine
     * @return
     */
    @RequestMapping(value = "addTimeLine", method = RequestMethod.POST)
    @ResponseBody
    public HttpResult addTimeLine(TimeLineVO timeLine){
        HttpResult result = new HttpResult();
        String Symbol = "#";
        String content = timeLine.getContent();
        int number = 2;
        //判断是否上传了图片，添加不同图标
        String imageUrl = timeLine.getImageUrl();
        if (StringUtils.isNotBlank(imageUrl)){
            timeLine.setColor("cd-timeline-img cd-picture");
            timeLine.setPicture("/images/cd-icon-picture.svg");
        }else{
            timeLine.setColor("cd-timeline-img cd-movie");
            timeLine.setPicture("/images/cd-icon-location.svg");
        }
        if (StrUtils.StrCount(content,Symbol) >= number ){
            String cutTitle = StrUtils.getCutOutString(timeLine.getContent(), Symbol, Symbol);
            timeLine.setTitle(cutTitle);
            int i = content.indexOf(Symbol);
            String substring = content.substring(content.indexOf(Symbol, i+1)+1);
            timeLine.setContent(substring);
        }else{
            String dateShort = DateUtil.getStringDateShort();
            timeLine.setTitle(dateShort);
        }
        uploadService.addTimeLine(timeLine);
        return result;
    }

    /**
     * 上传图片
     * @param file
     * @return
     */
    @RequestMapping(value = "uploadImage", method = RequestMethod.POST)
    @ResponseBody
    public HttpResult upload(@RequestParam("file") MultipartFile file){
        logger.info("@@1.上传图片 uploadImage start @@");
        HttpResult result = new HttpResult();
        String path = UUID.randomUUID().toString() + ".jpg";
        String filePath = ConstantClassField.UPLOAD_PATH+ path;
        if (!file.isEmpty()){
            try {
                file.transferTo(new File(filePath));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        ImageVO pojo = new ImageVO();
        pojo.setUrl(ConstantClassField.IMAGE_URL_PATH+path);
        result.setData(pojo);
        logger.info("@@2.上传图片 uploadImage end @@");
        return result;
    }


    /**
     * 删除图片
     * @param path
     * @return
     */
    @RequestMapping(value = "deleteImage", method = RequestMethod.POST)
    @ResponseBody
    public HttpResult deleteImage(@RequestParam("path") String path ){
        logger.info("@@1.删除图片 deleteImage start @@");
        String replace = path.replace(ConstantClassField.IMAGE_URL_PATH, "");
        String absPath = ConstantClassField.TEMP_PATH+ replace;
        File file = new File(absPath);
        HttpResult result = new HttpResult();
        if (!file.exists()){
            result.setStatus(500);
            result.setMsg("文件已经丢失 ~");
            return result;
        }
        FileUtils.delFile(absPath);
        result.setStatus(1);
        logger.info("@@2.删除图片 deleteImage end @@");
        return result;
    }

}
