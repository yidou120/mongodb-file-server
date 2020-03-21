package com.edou.fileserver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @ClassName SecurityConfig
 * @Description 安全配置类
 * @Author 中森明菜
 * @Date 2020/3/21 18:54
 * @Version 1.0
 */
@Configuration
@EnableWebMvc
public class SecurityConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*") ; // 允许跨域请求
    }
}