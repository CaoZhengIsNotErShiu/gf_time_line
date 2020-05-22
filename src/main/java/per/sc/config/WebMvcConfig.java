package per.sc.config;

import java.io.File;
import java.nio.charset.Charset;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.*;
import per.sc.constant.ConstantClassField;

/**
 * 版    权:  Bulin Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  boye
 *
 * @author Macx
 * @version [版本号, 2019/4/10 010]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {


    @Autowired
    private FilterConfig filterConfig;

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(filterConfig).addPathPatterns("/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String tempPath = "F:"+ File.separator+"ImagePath"+File.separator;
        String uploadPath = "F:"+ File.separator+"uploadImage"+File.separator;
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/image/**")
                .addResourceLocations("file:"+ ConstantClassField.TEMP_PATH)
                .addResourceLocations("file:"+tempPath)
                .addResourceLocations("file:"+uploadPath);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //设置允许跨域的路径
        registry.addMapping("/**")
                //设置允许跨域请求的域名
                .allowedOrigins("*")
                //是否允许证书 不再默认开启
                .allowCredentials(true)
                //设置允许的方法
                .allowedMethods("*")
                //跨域允许时间
                .maxAge(3600);
    }


}

