package com.nd.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * describe:
 *
 * @author nd.414567
 * @date 2018/07/03
 */
public class TestInterceptor implements HandlerInterceptor {
    /*
      目标方法开始之前进行拦截
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle目标方法执行");
        return true;
    }


    /*
        在目标方法执行之后进行执行
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle在目标方法执行之后进行执行");
    }

    /*
    页面相应之后。
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion页面相应之后");
    }
}
