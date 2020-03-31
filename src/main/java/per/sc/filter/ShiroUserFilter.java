package per.sc.filter;


import org.apache.shiro.web.filter.authc.UserFilter;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 解决前后端分离 OPTIONS 请求 被拦截的问题
 * <p>
 * 重写 shiro 的 UserFilter 过滤器 OPTIONS 请求  返回成功 并设置跨域
 *
 * @author 张朋
 * @email 494009061@qq.com
 * @date 2019/11/5 18:27
 */
public class ShiroUserFilter extends UserFilter {

    /**
     * 在访问过来的时候检测是否为OPTIONS请求，如果是就直接返回true
     */
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        // 如果是 OPTIONS 请求 直接返回成功 并设置跨域
        if (httpRequest.getMethod().equals(HttpMethod.OPTIONS.name())) {
            //设置跨域
            setHeader((HttpServletResponse) response);
            return true;
        }
        return super.preHandle(request, response);

    }

    private void setHeader(HttpServletResponse httpResponse) {
        httpResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpResponse.setHeader("Access-Control-Allow-Headers", "*");
        httpResponse.setHeader("Access-Control-Allow-Methods", "*");
        httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
        httpResponse.setHeader("Access-Control-Max-Age", "3600");
        //防止乱码，适用于传输JSON数据
        httpResponse.setHeader("Content-Type", "application/json;charset=UTF-8");
        httpResponse.setStatus(HttpStatus.OK.value());
    }


}
