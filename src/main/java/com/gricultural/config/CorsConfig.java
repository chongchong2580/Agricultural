package com.gricultural.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: chongchong
 * @DateTime: 2023/3/9 2:31
 * @Description:CORS实现跨域访问
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")                  //允许跨域访问的路径
                .allowedOrigins("*")                          //允许跨域访问的源
//                .allowedMethods("POST","GET","PUT","OPTIONS","DELETE")    //允许访问的方法
                .allowedMethods("POST","GET","PUT","DELETE")    //允许访问的方法
                .maxAge(168000)                                 //预约间隔时间
                .allowedHeaders("*")                            //允许头部设置
                .allowCredentials(true);                        //是否发送cookie
    }
}
