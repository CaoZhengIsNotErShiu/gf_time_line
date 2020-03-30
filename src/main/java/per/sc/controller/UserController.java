package per.sc.controller;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;
import per.sc.annotation.SystemControllerLog;
import per.sc.constant.ConstantClassField;
import per.sc.pojo.ImageVO;
import per.sc.pojo.UserVO;
import per.sc.pojo.dto.UserFollArtDTO;
import per.sc.service.UserServiceI;
import per.sc.util.*;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

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

    @Autowired
    private IdWorker idWorker;

    /**
     * 手机号注册
     * @param user 用户
     * @param session session
     * @return 返回登录结果
     */
    @RequestMapping(value = "pregister",method = RequestMethod.POST)
    @ResponseBody
    @SystemControllerLog(description = "手机号注册")
    public HttpResult pRegister(UserVO user,
                                HttpSession session){

        HttpResult result = new HttpResult();
        try {
            //1.判断账号是否注册
            UserVO user1 = userService.checkPhone(user.getPhone());

            if (user1 != null){
                result.setStatus(304);
                result.setMsg("手机号已经被注册，直接去登录~");
                return result;
            }else {
                //2.获取session中验证码
                String codeSession = (String) session.getAttribute(user.getPhone());
                System.out.println("phone = "+ user.getPhone() +"，code = " + codeSession + ",sessionId = "+ session.getId());
                if (StringUtils.isBlank(codeSession) || !user.getCode().equals(codeSession) ){
                    result.setStatus(2);
                    result.setMsg("验证码错误，请重新获取 ~");
                    return result;
                }
                //注册
                user.setId(idWorker.nextId()+"");
                String date = DateUtil.getStringAllDate();
                user.setUserName("TL_"+date);
                //MD5加密搞上
                String initPwd = MD5Util.getMD5WithSalt(user.getPassword());
                user.setPassword(initPwd);
                user.setImage("/38421562074311_.pic.jpg");
                userService.register(user);
                result.setStatus(200);
                result.setMsg("注册成功！ ~");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    /**
     * 账号密码登录
     * @return 返回登录结果
     */
    @RequestMapping(value = "dologin",method = RequestMethod.POST)
    @ResponseBody
    @SystemControllerLog(description = "账号密码登录")
    public HttpResult plogin(UserVO user){
        logger.info("@@1.账号密码登录  plogin start @@");
        HttpResult result = new HttpResult();
        UserVO userVO = null;
        try {
            //把用户输入的密码md5加密
            String loginPwd = MD5Util.getMD5WithSalt(user.getPassword());
            userVO = userService.checkPhone(user.getPhone());
            if (userVO != null){
                String mysqlPwd = userVO.getPassword();
                boolean flag = loginPwd.equals(mysqlPwd);
                if (flag){
                    result.setStatus(0);
                    result.setMsg("登录成功，即将跳转 ~");
                    //隐藏手机号中间4位，清空用户密码
                    userVO.setPhone(userVO.getPhone().replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2"));
                    userVO.setPassword("");
                    result.setData(userVO);
                }else{
                    result.setStatus(1);
                    result.setMsg("账号/密码出现了错误 ~");
                }
            }else{
                result.setStatus(2);
                result.setMsg("您还没有注册，请先去注册 ~");
            }
        } catch (Exception e) {
            logger.info("## 1.账号密码登录  plogin err ##",e);
        }
        logger.info("@@2.账号密码登录  plogin end @@");
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
    @SystemControllerLog(description = "手机号登陆")
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
                result.setMsg("验证码错误，请重新输入 ~");
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


    /**
     * 生成验证码
     * @param phone
     * @param session
     * @return
     */
    @RequestMapping(value = "getCode",method = RequestMethod.POST)
    @ResponseBody
    @SystemControllerLog(description = "生成验证码")
    public HttpResult getCode(@RequestParam("phone")String phone,HttpSession session){
        HttpResult result = new HttpResult();
        logger.info("@@1.生成验证码 checkPhone start @@");
        //判断号码是否被注册
        UserVO vo = null;
        try {
            vo = userService.checkPhone(phone);
            if (vo != null){
                result.setStatus(304);
                result.setMsg("手机号已经被注册，直接去登录~");
            }else{
                //1.生成验证码
                String code = RandomUtils.randomCode();
                System.out.println("phone = " + phone + "验证码:"+code);
                //2.放到session中
                session.setAttribute(phone,code);
                int appid = 1400233127;
                String appkey = "6aac7712ca79ddc6ed5f2e8df940da84";
                SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
                // 需要发送短信的手机号码
                String[] phoneNumbers = {phone};
//                SmsSingleSenderResult result1 = ssender.send(0, "86", phoneNumbers[0],
//                        "验证码为："+ code +"，您正在注册成为TimeLine平台会员，感谢您的支持！", "", "");
//                System.out.println(result1);
                String str  = (String) session.getAttribute(phone);
                System.out.println("phone = "+ str + "sessionId = "+ session.getId());
                result.setStatus(200);
                result.setMsg("发送短信验证码成功，请注意查看您的手机");
            }
        } catch (Exception e) {
            logger.error("##1.生成验证码 checkPhone err ##", e);
        }
        return result;
    }


    /**
     * 根据用户名查询用户信息
     * @param userName 用户名
     * @return 返回
     */
    @RequestMapping(value = "queryUserByName",method = RequestMethod.POST)
    @ResponseBody
    @SystemControllerLog(description = "根据用户名查询用户信息")
    public HttpResult queryUserByName(@RequestParam("userName") String userName){
        logger.info("@@1.根据用户名查询用户信息 queryUserByName start @@");
        //判断号码是否被注册
        UserVO vo = null;
        try {
            vo = userService.queryUserByName(userName);
        } catch (Exception e) {
            logger.error("##1.根据用户名查询用户信息 queryUserByName err ##", e);
        }
        HttpResult result = new HttpResult();
        result.setStatus(200);
        result.setData(vo);
        logger.info("@@2.根据用户名查询用户信息 queryUserByName end @@");
        return result;
    }


    /**
     * 上传用户图像
     * @param file
     * @return
     */
    @RequestMapping(value = "uploadUserImage", method = RequestMethod.POST)
    @ResponseBody
    @SystemControllerLog(description = "上传用户图像")
    public HttpResult uploadUserImage(@RequestParam("file") MultipartFile file){
        logger.info("@@1.上传用户图像 uploadUserImage start @@");
        HttpResult result = new HttpResult();
        String path = UUID.randomUUID().toString() + ".jpg";
        String filePath = ConstantClassField.TEMP_PATH + path;
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
        logger.info("@@2.上传用户图像 uploadUserImage end @@");
        return result;
    }

    /**
     * 查询用户文章数，关注度
     * @param userName 用户id
     * @param loginName 登录id
     * @return
     */
    @RequestMapping(value = "queryUserInfoByUserId", method = RequestMethod.POST)
    @ResponseBody
    @SystemControllerLog(description = "查询用户文章数，关注度")
    public HttpResult queryUserInfoByUserId(String userName,String loginName){
        logger.info("@@1.查询用户文章数，关注度 queryUserInfoByUserId start @@");
        HttpResult result = new HttpResult();
        try {
            String userId = userService.queryUserIdByUserName(userName);
            //判断用户是否登录
            String loginId = "0";
            if (StringUtils.isNotBlank(loginName)){
                loginId = userService.queryUserIdByUserName(loginName);
            }
            UserFollArtDTO dto =  userService.queryUserInfoByUserId(Integer.valueOf(userId),Integer.valueOf(loginId));
            result.setStatus(200);
            result.setData(dto);
        } catch (Exception e) {
            result.setStatus(500);
            logger.error("## 1.查询用户文章数，关注度 queryUserInfoByUserId err ##", e);
        }
        logger.info("@@2.查询用户文章数，关注度 queryUserInfoByUserId end @@");
        return result;
    }

}
