package per.sc.config;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import per.sc.pojo.Permission;
import per.sc.pojo.Role;
import per.sc.pojo.UserVO;
import per.sc.service.UserServiceI;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Administrator
 * @date 2020/3/31
 */
public class UserRealm extends AuthorizingRealm {


    @Autowired
    private UserServiceI userService;

    /**
     *shiro的权限信息配置
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        String uid = (String) principals.getPrimaryPrincipal();
        List<Role> roles = userService.findRoles(Integer.valueOf(uid));
        Set<String> roleNames = new HashSet<>(roles.size());
        for (Role role : roles) {
            roleNames.add(role.getRoleName());
        }
        //此处把当前subject对应的所有角色信息交给shiro，调用hasRole的时候就根据这些role信息判断
        authorizationInfo.setRoles(roleNames);
        List<Permission> permissions = userService.findPermissions(Integer.valueOf(uid));
        Set<String> permissionNames = new HashSet<>(permissions.size());
        for (Permission permission : permissions) {
            permissionNames.add(permission.getPermissionsName());
        }
        //此处把当前subject对应的权限信息交给shiro，当调用hasPermission的时候就会根据这些信息判断
        authorizationInfo.setStringPermissions(permissionNames);
        return authorizationInfo;
    }

    /**
     * 根据token获取认证信息authenticationInfo
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        /**这里为什么是String类型呢？其实要根据Subject.login(token)时候的token来的，
         * 你token定义成的pricipal是啥，这里get的时候就是啥。比如我
         **/
        String uId = (String) token.getPrincipal();
        UserVO user = userService.findUserById(uId);
        if (user == null) {
            return null;
        }
        //SimpleAuthenticationInfo还有其他构造方法，比如密码加密算法等，感兴趣可以自己看
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                //表示凭证，可以随便设，跟token里的一致就行
                user.getPhone(),
                //表示密钥如密码，你可以自己随便设，跟token里的一致就行
                user.getPassword(),
                getName()
        );
        //authenticationInfo信息交个shiro，调用login的时候会自动比较这里的token和authenticationInfo
        return authenticationInfo;
    }




}