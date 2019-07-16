package per.sc.controller;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.qcloudsms.httpclient.HTTPException;
import org.json.JSONException;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

/**
 *
 * @author Administrator
 * @date 2019/7/16
 */
@Controller
@RequestMapping("user")
public class UserController {

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






    @RequestMapping(value = "getCode",method = RequestMethod.POST)
    public String getCode(){
        try {
            //1.先去数据库查询是否存在该账户
            //2.存在则返回，否则调用生成验证码
            int appid = 1400233127;
            String appkey = "6aac7712ca79ddc6ed5f2e8df940da84";
            SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
            // 需要发送短信的手机号码
            String[] phoneNumbers = {"15651367595", "17625726225", "12345678903"};

            SmsSingleSenderResult result = ssender.send(0, "86", phoneNumbers[0],
                    "验证码：6379，用于注册TimeLine帐号，1分钟内有效。如非本人操作，请忽略。", "", "");
            System.out.println(result);
        } catch (HTTPException e) {
            // HTTP 响应码错误
            e.printStackTrace();
        } catch (JSONException e) {
            // JSON 解析错误
            e.printStackTrace();
        } catch (IOException e) {
            // 网络 IO 错误
            e.printStackTrace();
        }
        return "";
    }
}
