package com.nd.s414567.argresolver;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * describe:
 *
 * @author nd.414567
 * @date 2018/07/10
 */
public interface ArgResolver {

    public boolean isSupport(Method method,int paramIndex,Class<?>params);
    public Object argResolver(HttpServletRequest request, HttpServletResponse response,Method method, int paramIndex, Class<?>params);

}
