package com.spring.demo.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * 跨域配置
 * @author liu
 * @version 1.0
 * @description
 * @createDate 2020/11/12
 */
public class CorsConfig implements WebMvcConfigurer {


    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**")
                //允许跨域的域名，可以用*表示允许任何域名使用
                .allowedOrigins("*")
                //带上cookie信息
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "DELETE", "PUT")
                //表明在3600秒内，不需要再发送预检验请求，可以缓存该结果
                .maxAge(3600);
    }
}
