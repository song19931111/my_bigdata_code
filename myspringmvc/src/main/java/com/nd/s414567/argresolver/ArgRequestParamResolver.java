package com.nd.s414567.argresolver;

import com.nd.s414567.annotation.AnnoRequestParam;
import com.nd.s414567.annotation.AnnoService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * describe:
 *
 * @author nd.414567
 * @date 2018/07/10
 */
@AnnoService("argRequestParamResolver")
public class ArgRequestParamResolver implements ArgResolver{
    @Override
    public boolean isSupport(Method method, int paramIndex, Class<?> params) {
        //返回的是一个二维数组，第一维代表每一个参数 ，第二维代表每一个参数的注解
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        Annotation[] annotations = parameterAnnotations[paramIndex];
        for(Annotation annotation:annotations){
            if(AnnoRequestParam.class.isAssignableFrom(annotation.getClass())){
                return true;
            }
        }
        return false;
    }

    @Override
    public Object argResolver(HttpServletRequest request, HttpServletResponse response, Method method, int paramIndex, Class<?> params) {
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        Annotation[] annotations = parameterAnnotations[paramIndex];
        for(Annotation annotation:annotations){
            if(AnnoRequestParam.class.isAssignableFrom(annotation.getClass())){
                AnnoRequestParam annoRequestParam = (AnnoRequestParam)annotation;
                String value = annoRequestParam.value();
                request.getParameter(value);
                return  value;
            }
        }
        return null;
    }
}
