package com.nd.s414567.argresolver;

import com.nd.s414567.annotation.AnnoService;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * describe:
 *
 * @author nd.414567
 * @date 2018/07/10
 */
@AnnoService("argHttpRequestServletResolver")
public class ArgHttpRequestServletResolver implements ArgResolver{
    @Override
    public boolean isSupport(Method method, int paramIndex, Class<?> params) {

        if(ServletRequest.class.isAssignableFrom(params)){
            return true;
        }
        return false;
    }

    @Override
    public Object argResolver(HttpServletRequest request, HttpServletResponse response, Method method, int paramIndex, Class<?> params) {
        return request;
    }
}
