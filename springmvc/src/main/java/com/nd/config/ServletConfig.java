package com.nd.config;

import com.nd.interceptor.TestInterceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.config.annotation.*;

/**
 * describe:
 *
 * @author nd.414567
 * @date 2018/07/03
 */
@EnableWebMvc

@ComponentScan(value = "com.nd",includeFilters = {
        @ComponentScan.Filter(value = Controller.class),
},useDefaultFilters = false)
public class ServletConfig extends WebMvcConfigurerAdapter {
    /**
     * JSP解析
     */
    @Override
  public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/pages/",".jsp");
    }

    /**
     * 静态资源的访问
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //对order进行拦截
        registry.addInterceptor(new TestInterceptor()).addPathPatterns("/*");
    }
}
