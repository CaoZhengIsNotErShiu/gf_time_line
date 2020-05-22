package per.sc.service.impl;

import com.github.qcloudsms.SmsSingleSender;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import per.sc.mapper.UserMapper;
import per.sc.pojo.Permission;
import per.sc.pojo.Role;
import per.sc.pojo.User;
import per.sc.pojo.UserVO;
import per.sc.pojo.dto.UserFollArtDTO;
import per.sc.result.ResultData;
import per.sc.service.UserServiceI;
import per.sc.service.base.BaseMapper;
import per.sc.service.base.BaseServiceImpl;
import per.sc.util.*;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 *
 * @author Administrator
 * @date 2019/7/17
 */
@Slf4j
@Service
public class UserServiceImpl extends BaseServiceImpl<User,String> implements UserServiceI {
    @Override
    public UserVO checkPhone(String phone) {
        return null;
    }

    @Override
    public void register(UserVO user) {

    }

    @Override
    public String queryUserIdByUserName(String createUser) {
        return null;
    }

    @Override
    public UserVO queryUserByName(String userName) {
        return null;
    }

    @Override
    public UserFollArtDTO queryUserInfoByUserId(Integer userId, Integer loginId) {
        return null;
    }

    @Override
    public List<Role> findRoles(Integer id) {
        return null;
    }

    @Override
    public List<Permission> findPermissions(Integer id) {
        return null;
    }

    @Override
    public UserVO findUserById(String uId) {
        return null;
    }

    @Override
    public ResultData plogin(User user, HttpServletRequest request) {
        return null;
    }

    @Override
    public ResultData pRegister(User user, HttpSession session) {
        return null;
    }

    @Override
    public ResultData getCode(String phone, HttpSession session) {
        return null;
    }

    @Override
    public ResultData getUserInfo() {
        return null;
    }

    @Override
    public BaseMapper<User, String> getMappser() {
        return null;
    }

//    @Autowired
//    private UserMapper userMapper;
//
//    @Autowired
//    private IdWorker idWorker;
//    /**
//     * 查询该号码是否被注册
//     * @param phone 电话号码
//     * @return 返回用户信息
//     */
//    @Override
//    @Transactional(rollbackFor = Exception.class)
//    public UserVO checkPhone(String phone) {
//        return userMapper.checkPhone(phone);
//    }
//
//    /**
//     * 注册用户信息
//     * @param user 用户信息
//     */
//    @Override
//    @Transactional(rollbackFor = Exception.class)
//    public void register(UserVO user) {
//        userMapper.register(user);
//    }
//
//    /**
//     * 根据用户名查询用户id
//     * @param createUser 用户名
//     * @return 用户id
//     */
//    @Override
//    @Transactional(rollbackFor = Exception.class)
//    public String queryUserIdByUserName(String createUser) {
//        return userMapper.queryUserIdByUserName(createUser);
//    }
//
//    /**
//     * 根据用户名查询用户信息
//     * @param userName
//     * @return
//     */
//    @Override
//    @Transactional(rollbackFor = Exception.class)
//    public UserVO queryUserByName(String userName) {
//        return userMapper.queryUserByName(userName);
//    }
//
//    /**
//     * 查询用户文章数，关注度
//     * @param userId 用户id
//     * @return
//     */
//    @Override
//    public UserFollArtDTO queryUserInfoByUserId(Integer userId, Integer loginId) {
//        return userMapper.queryUserInfoByUserId(userId,loginId);
//    }
//
//    /**
//     * 根据用户id查询所有的角色信息
//     */
//    public List<Role> findRoles(Integer id) {
//        return  userMapper.getRoleByUserId(id);
//    }
//
//    //根据用户的id查询所有权限信息
//    public List<Permission> findPermissions(Integer id) {
//        return userMapper.getPermissionByUserId(id);
//    }
//
//    @Override
//    public UserVO findUserById(String uId) {
//        return userMapper.findUserById(uId);
//    }
//
//    @Override
//    public ResultData plogin(User user, HttpServletRequest request) {
//        log.info("@@1.账号密码登录  plogin start @@");
//
//        User user1 = new User();
//
//        return ResultData.success(user1);
//    }
//
//    @Override
//    public ResultData pRegister(User user, HttpSession session) {
//        log.info("##1.注册账号 pRegister start ##");
//        if (!user.getPassword().equals(user.getPassword_confirm())){
//            return ResultData.error("两次密码不一致~");
//        }
//        try {
//            Example example = new Example(User.class);
//            example.createCriteria()
//                    .andEqualTo("phone",user.getPhone());
//            //1.判断账号是否注册
//            int i = userMapper.selectCountByExample(example);
//            if ( 0 != i){
//                return ResultData.error("手机号已经被注册，直接去登录~");
//            }
//            //2.获取session中验证码
//            String codeSession = (String) session.getAttribute(user.getPhone());
//            System.out.println("phone = "+ user.getPhone() +"，code = " + codeSession + ",sessionId = "+ session.getId());
//            if (StringUtils.isBlank(codeSession) || !user.getCode().equals(codeSession) ){
//                return ResultData.error("验证码错误，请重新获取 ~");
//            }
//            //注册
//            user.setId(idWorker.nextId()+"");
//            String date = DateUtil.getStringAllDate();
//            user.setUserName("TL_"+date);
//            //MD5加密搞上
//            String initPwd = MD5Util.getMD5WithSalt(user.getPassword());
//            user.setPassword(initPwd);
//            user.setImage("/38421562074311_.pic.jpg");
//            user.setRoleId(1);
//            userMapper.insertSelective(user);
//        } catch (Exception e) {
//            log.error("@@1.注册账号 pRegister err ##",e.getMessage());
//            return ResultData.error(e.getMessage());
//        }
//        log.info("##2.注册账号 pRegister end ##");
//        return ResultData.success("注册成功！ ~");
//    }
//
//    @Override
//    public ResultData getCode(String phone, HttpSession session) {
//        log.info("@@1.生成验证码 checkPhone start @@");
//        //判断号码是否被注册
//        User vo = null;
//        try {
//            List<User> users = getValueByExample(new User(),"phone",phone);
//            if (users.size() != 0){
//                return ResultData.error("手机号已经被注册，直接去登录~");
//            }else{
//                //1.生成验证码
//                String code = RandomUtils.randomCode();
//                System.out.println("phone = " + phone + "验证码:"+code);
//                //2.放到session中
//                session.setAttribute(phone,code);
//                int appid = 1400233127;
//                String appkey = "6aac7712ca79ddc6ed5f2e8df940da84";
//                SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
//                // 需要发送短信的手机号码
//                String[] phoneNumbers = {phone};
////                SmsSingleSenderResult result1 = ssender.send(0, "86", phoneNumbers[0],
////                        "验证码为："+ code +"，您正在注册成为TimeLine平台会员，感谢您的支持！", "", "");
////                System.out.println(result1);
//                String str  = (String) session.getAttribute(phone);
//                System.out.println("phone = "+ str + "sessionId = "+ session.getId());
//            }
//        } catch (Exception e) {
//            log.error("##1.生成验证码 checkPhone err ##", e.getMessage());
//        }
//        return ResultData.success("发送短信验证码成功，请注意查看您的手机");
//    }
//
//    @Override
//    public ResultData getUserInfo() {
//        log.info("@@1.根据用户名查询用户信息 getUserInfo start @@");
//        //判断号码是否被注册
//        UserVO vo = null;
//        try {
//
//        } catch (Exception e) {
//            log.error("##1.根据用户名查询用户信息 getUserInfo err ##", e.getMessage());
//            return ResultData.error(e.getMessage());
//        }
//        log.info("@@2.根据用户名查询用户信息 getUserInfo end @@");
//        return ResultData.success(vo);
//    }
//
//    @Override
//    public BaseMapper<User, String> getMappser() {
//        return userMapper;
//    }
}
