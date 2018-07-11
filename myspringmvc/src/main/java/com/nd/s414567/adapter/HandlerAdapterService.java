package com.nd.s414567.adapter;

import com.nd.s414567.annotation.AnnoService;
import com.nd.s414567.argresolver.ArgResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * describe:
 *
 * @author nd.414567
 * @date 2018/07/10
 */
@AnnoService("handlerAdapterService")
public class HandlerAdapterService implements HandlerAdapter{


    @Override
    public Object[] handle(HttpServletRequest request, HttpServletResponse response, Method method, Map<String, Object> beans) {
        Class<?>[] parameterTypes = method.getParameterTypes();
        Object [] obj  = new Object[parameterTypes.length];

        //寻找实现ArgResolver的类:
        Map<String,Object>argResolveBeans = getBeanOfType(ArgResolver.class,beans);
        int paramIndex = 0;
        int objIndexCount = 0;

        for(Class<?>cls:parameterTypes){
            for(Map.Entry<String,Object>entry:argResolveBeans.entrySet()){
                ArgResolver argResolver = (ArgResolver) entry.getValue();
                if(argResolver.isSupport(method,paramIndex,cls)){
                    obj [objIndexCount++] = argResolver.argResolver(request,response,method,paramIndex,cls);
                }
            }
            paramIndex++;

        }


        return obj;
    }

    private Map<String,Object> getBeanOfType(Class<?> interfaceClass, Map<String,Object> beans) {
        Map<String,Object>resultBean = new HashMap<>();
        for(Map.Entry<String,Object>entry:beans.entrySet()){
            Object instance = entry.getValue();
            Class<?>[] interfaces = instance.getClass().getInterfaces();
            if(interfaces != null && interfaces.length>0){
                for(Class<?>interface_:interfaces){
                    if(interfaceClass.isAssignableFrom(interface_)){
                        //如果interfaceClass是本身或者父类
                        resultBean.put(entry.getKey(),entry.getValue());
                    }
                }
            }
        }
        return  resultBean;



    }


}
