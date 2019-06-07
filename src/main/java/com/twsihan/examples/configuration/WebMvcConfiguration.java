package com.twsihan.examples.configuration;

import com.twsihan.examples.interceptor.LocalInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer
{


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry)
    {
        // registry.addResourceHandler("/webStatic/**").addResourceLocations("classpath:/webStatic/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry)
    {
        // registry.addInterceptor(new LocalInterceptor()).addPathPatterns("/**").excludePathPatterns("/static/**");
    }
}
