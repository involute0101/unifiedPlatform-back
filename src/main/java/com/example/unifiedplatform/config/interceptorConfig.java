package com.example.unifiedplatform.config;


import com.example.unifiedplatform.interceptor.AuthenticationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器配置类
 */
@Configuration
public class interceptorConfig implements WebMvcConfigurer {

    /**
     * 设置拦截哪些路径，不拦截哪些路径
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(authenticationInterceptor())
                //添加拦截路径
                .addPathPatterns("/**")
                //添加白名单路径
                .excludePathPatterns("/swagger-resources/**");
    }

    /**
     * 全局注入拦截器配置Bean
     * @return
     */
    @Bean
    public AuthenticationInterceptor authenticationInterceptor(){
        return new AuthenticationInterceptor();
    }
}

