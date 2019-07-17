package per.sc.controller;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPRequest;
import com.github.qcloudsms.httpclient.HTTPResponse;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.qcloudsms.httpclient.HTTPException;
import org.json.JSONException;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import per.sc.pojo.UserVO;
import per.sc.service.UserServiceI;
import per.sc.util.DateUtil;
import per.sc.util.HttpResult;
import per.sc.util.RandomUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Random;

/**
 *
 * @author Administrator
 * @date 2019/7/16
 */
@Controller
@RequestMapping("user")
public class UserController {


    private static final Logger logger =
            LogManager.getLogger(UserController.class);

    @Autowired
    private UserServiceI userService;


    /**
     * 展示登录界面
     * @return 返回登录界面
     */
    @RequestMapping("showLogin")
    public String showLogin(){
        return "login/index";
    }

    /**
     * 展示注册界面
     * @return 返回注册界面
     */
    @RequestMapping("showReg")
    public String showReg(){
        return "login/reg";
    }


    /**
     * 手机号登陆
     * @param phone 手机号
     * @param session session
     * @return 返回登录结果
     */
    @RequestMapping(value = "pregister",method = RequestMethod.POST)
    @ResponseBody
    public HttpResult pRegister(@RequestParam("phone")String phone,
                             @RequestParam("code")String code,
                             HttpSession session){
        HttpResult result = new HttpResult();
        UserVO userVO = null;
        try {
            //1.获取session中验证码
            String codeSession = (String) session.getAttribute(phone);
            userVO = userService.checkPhone(phone);
            if (StringUtils.isBlank(codeSession) ||!code.equals(codeSession) ){
                result.setStatus(2);
                result.setMsg("验证码错误，请重新获取 ~");
                return result;
            }
            if (userVO != null){
                result.setStatus(0);
                result.setMsg("该手机号已经被注册，请直接登录 ~");
            }else{
                //注册
                String date = DateUtil.getStringAllDate();
                UserVO user = new UserVO();
                user.setUserName("TL_"+date);
                user.setPhone(phone);
                //MD5加密搞上
                user.setPassword("123456");
                user.setImage("/38421562074311_.pic.jpg");
                userService.register(user);
                result.setStatus(1);
                result.setMsg("注册成功！ ~");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 手机号登陆
     * @param phone 手机号
     * @param session session
     * @return 返回登录结果
     */
    @RequestMapping(value = "plogin",method = RequestMethod.POST)
    @ResponseBody
    public HttpResult plogin(@RequestParam("phone")String phone,
                             @RequestParam("code")String code,
                             HttpSession session){
        HttpResult result = new HttpResult();
        UserVO userVO = null;
        try {
            //1.获取session中验证码
            String codeSession = (String) session.getAttribute(phone);
            userVO = userService.checkPhone(phone);
            if (StringUtils.isBlank(codeSession) ||!code.equals(codeSession) ){
                result.setStatus(2);
                result.setMsg("验证码错误，请重新获取 ~");
                return result;
            }
            if (userVO != null){
                result.setStatus(0);
                result.setMsg("登录成功 ~");
            }else{
                result.setStatus(1);
                result.setMsg("您还没有注册！ ~");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    @RequestMapping(value = "getCode",method = RequestMethod.POST)
    @ResponseBody
    public HttpResult getCode(@RequestParam("phone")String phone,HttpSession session){
        HttpResult result = new HttpResult();
        try {
            //1.生成验证码
            String code = RandomUtils.randomCode();
            System.out.println("验证码:"+code);
            //2.放到session中
            session.setAttribute(phone,code);
            int appid = 1400233127;
            String appkey = "6aac7712ca79ddc6ed5f2e8df940da84";
            SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
            // 需要发送短信的手机号码
            String[] phoneNumbers = {phone};
//            SmsSingleSenderResult result = ssender.send(0, "86", phoneNumbers[0],
//                    "验证码：6379，用于注册TimeLine帐号，1分钟内有效。如非本人操作，请忽略。", "", "");
           // System.out.println(result);
            result.setStatus(0);
            result.setMsg("获取验证码成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 检查手机号是否注册
     * @param phone 手机号
     * @return 返回
     */
    @RequestMapping(value = "checkPhone",method = RequestMethod.POST)
    @ResponseBody
    public HttpResult checkPhone(@RequestParam("phone") String phone){
        logger.info("@@1.检查手机号是否注册 checkPhone start @@");
        //判断号码是否被注册
        UserVO vo = null;
        try {
            vo = userService.checkPhone(phone);
        } catch (Exception e) {
            logger.error("##1.检查手机号是否注册 checkPhone err ##", e);
        }
        HttpResult result = new HttpResult();
        if (vo != null){
            result.setStatus(200);
            result.setMsg("手机号已经被注册，直接去登录~");
        }else {
            result.setStatus(500);
            result.setMsg("可注册 ~");
        }
        logger.info("@@2.检查手机号是否注册 checkPhone end @@");
        return result;
    }
}
