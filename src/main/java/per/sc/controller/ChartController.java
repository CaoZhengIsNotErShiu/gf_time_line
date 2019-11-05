package per.sc.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import per.sc.constant.ConstantClassField;
import per.sc.pojo.ChartVO;
import per.sc.pojo.ImageVO;
import per.sc.service.ChartServiceI;
import per.sc.util.HttpResult;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * 图表
 *
 * @author Administrator
 * @date 2019/8/23
 */
@RestController
@RequestMapping("chart")
public class ChartController {

    private static final Logger logger =
            LogManager.getLogger(ChartController.class);

    @Autowired
    private ChartServiceI chartServie;

    /**
     * 过去七天发帖量
     * @return
     */
    @RequestMapping(value = "querySevenDays", method = RequestMethod.POST)
    @ResponseBody
    public HttpResult querySevenDays(){
        logger.info("@@1.过去七天发帖量 querySevenDays start @@");
        HttpResult result = new HttpResult();
        List<ChartVO> list = null;
        try {
            list = chartServie.querySevenDays();
            result.setStatus(200);
            result.setData(list);
        } catch (Exception e) {
            result.setStatus(500);
            logger.error("@@1.过去七天发帖量 querySevenDays err ##",e);
        }
        logger.info("@@2.过去七天发帖量 querySevenDays end @@");
        return result;
    }
}
