package per.sc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import per.sc.pojo.ReleaseListVO;
import per.sc.pojo.ReleaseVO;
import per.sc.service.ReleaseServiceI;
import per.sc.util.HttpResult;


/**
 * 版本
 * @author Administrator
 * @date 2019/11/28
 */
@RestController
@RequestMapping("release")
public class ReleaseController {

    @Autowired
    private ReleaseServiceI releaseServiceI;
    /**
     * 获取所有版本信息
     * @return
     */
    @RequestMapping("releaseInfo")
    public HttpResult queryAllReleaseInfo(){
        HttpResult result = new HttpResult();
        ReleaseListVO listVO = releaseServiceI.queryAllReleaseInfo();
        result.setStatus(200);
        result.setData(listVO);
        return result;
    }

    /**
     * 发布版本更新信息
     * @param release
     * @return
     */
    @RequestMapping("addRelease")
    public HttpResult addReleaseInfo(ReleaseVO release){
        HttpResult result = new HttpResult();
        releaseServiceI.addReleaseInfo(release);
        result.setStatus(200);
        return result;
    }
}
