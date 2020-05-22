package per.sc.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;
import per.sc.constant.ConstantClassField;
import per.sc.pojo.ImageVO;
import per.sc.pojo.User;
import per.sc.pojo.dto.UserFollArtDTO;
import per.sc.result.ResultData;
import per.sc.service.UserServiceI;
import per.sc.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 *
 * @author Administrator
 * @date 2019/7/16
 */
@Slf4j
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserServiceI userService;

    /**
     * 手机号注册
     * @param user 用户
     * @param session session
     * @return 返回登录结果
     */
    @RequestMapping(value = "pregister",method = RequestMethod.POST)
    @ResponseBody
    public ResultData pRegister(User user,
                                HttpSession session){
       return userService.pRegister(user,session);
    }

    /**
     * 账号密码登录
     * @return 返回登录结果
     */
    @RequestMapping(value = "dologin",method = RequestMethod.POST)
    @ResponseBody
    public ResultData plogin(User user, HttpServletRequest request){
        return userService.plogin(user,request);
    }



//    /**
//     * 手机号登陆
//     * @param phone 手机号
//     * @param session session
//     * @return 返回登录结果
//     */
//    @RequestMapping(value = "plogin",method = RequestMethod.POST)
//    @SystemControllerLog(description = "手机号登陆")
//    public HttpResult plogin(@RequestParam("phone")String phone,
//                             @RequestParam("code")String code,
//                             HttpSession session){
//        HttpResult result = new HttpResult();
//        UserVO userVO = null;
//        try {
//            //1.获取session中验证码
//            String codeSession = (String) session.getAttribute(phone);
//            userVO = userService.checkPhone(phone);
//            if (StringUtils.isBlank(codeSession) ||!code.equals(codeSession) ){
//                result.setStatus(2);
//                result.setMsg("验证码错误，请重新输入 ~");
//                return result;
//            }
//            if (userVO != null){
//                result.setStatus(0);
//                result.setMsg("登录成功 ~");
//            }else{
//                result.setStatus(1);
//                result.setMsg("您还没有注册！ ~");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return result;
//    }


    /**
     * 生成验证码
     * @param phone
     * @param session
     * @return
     */
    @RequestMapping(value = "getCode",method = RequestMethod.POST)
    public ResultData getCode(@RequestParam("phone")String phone,HttpSession session){
        return userService.getCode(phone, session);
    }


    /**
     * 根据用户名查询用户信息
     * @return 返回
     */
    @RequestMapping(value = "getUserInfo",method = RequestMethod.POST)
    public ResultData getUserInfo(){
        return userService.getUserInfo();
    }


    /**
     * 上传用户图像
     * @param file
     * @return
     */
    @RequestMapping(value = "uploadUserImage", method = RequestMethod.POST)
    public HttpResult uploadUserImage(@RequestParam("file") MultipartFile file){
        log.info("@@1.上传用户图像 uploadUserImage start @@");
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
        log.info("@@2.上传用户图像 uploadUserImage end @@");
        return result;
    }

    /**
     * 查询用户文章数，关注度
     * @param userName 用户id
     * @param loginName 登录id
     * @return
     */
    @RequestMapping(value = "queryUserInfoByUserId", method = RequestMethod.POST)
    public HttpResult queryUserInfoByUserId(String userName,String loginName){
        log.info("@@1.查询用户文章数，关注度 queryUserInfoByUserId start @@");
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
            log.error("## 1.查询用户文章数，关注度 queryUserInfoByUserId err ##", e);
        }
        log.info("@@2.查询用户文章数，关注度 queryUserInfoByUserId end @@");
        return result;
    }

}
