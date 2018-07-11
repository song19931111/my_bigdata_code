package com.nd.web;

import com.nd.config.RootConfig;
import com.nd.config.ServletConfig;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

/**
 * describe:创建感兴趣的类:
 *
 * @author nd.414567
 * @date 2018/07/03
 */
public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * 根容器
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        //根容器:

        return new Class[]{RootConfig.class};
    }

    /**
     * 子容器
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{ServletConfig.class};
    }


    /**
     * 拦截所有的请求（静态资源 js css png） 不包括*.jsp ,jsp的解析是tomcat的jsp解析引擎
     * @return
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
