package com.nd.s414567.adapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * describe:
 *
 * @author nd.414567
 * @date 2018/07/10
 */
public interface HandlerAdapter {

    public Object[] handle(HttpServletRequest request, HttpServletResponse response,Method method,Map<String,Object> beans);

}
