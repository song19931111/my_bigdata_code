package com.nd.s414567.servlet;

import com.nd.s414567.adapter.HandlerAdapter;
import com.nd.s414567.annotation.AnnoController;
import com.nd.s414567.annotation.AnnoQualifier;
import com.nd.s414567.annotation.AnnoRequestMapping;
import com.nd.s414567.annotation.AnnoService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * describe:
 *
 * @author nd.414567
 * @date 2018/07/10
 */
public class DispatchServlet extends HttpServlet {
    private List<String> classNames = new ArrayList<>();
    private Map<String,Object> beans = new HashMap<>();
    private Map<String,Object>handleMap = new HashMap<>();
    private Map<String,Object>handleMapController = new HashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String uri = req.getRequestURI();
        String contextPath = req.getContextPath();
        //  /项目名/test/query
        String url = uri.replaceAll(contextPath,"");
        //拿到Controller
        Object instanceController  = handleMapController.get(url);
        //拿到方法:
        Method method = (Method)handleMap.get(url);
        //拿到HandlerService:
        HandlerAdapter handlerAdapter = (HandlerAdapter)beans.get("handlerAdapterService");
        Object[] objects = handlerAdapter.handle(req, resp, method, beans);
        try {
            method.invoke(instanceController,objects);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void init() throws ServletException {
        //super.init();
        //扫描
        scanPackage("com.nd");
        System.out.println(classNames);
        //扫描AnnoController 和AnnoSerivce
       instance();
       //依赖注入:
        iocDI();
        //路径映射，一个路径和一个方法映射
        handleMapping();
        System.out.println(handleMap);

    }

    private void handleMapping() {
        for(Map.Entry<String,Object>entry:beans.entrySet()){
            //扫描每个类有没有@RequestMapping的注解:
            Object instance = entry.getValue();
            Class<?> cls = instance.getClass();
            if(cls.isAnnotationPresent(AnnoRequestMapping.class)){
                //取得类上的RequestMapping的值为根路径:
                String rootPath = cls.getAnnotation(AnnoRequestMapping.class).value();
                //遍历这个类的所有方法，看方法头上有没有声明@RequestMapping ：
                Method[] methods = cls.getMethods();
                for(Method method:methods){
                    if(method.isAnnotationPresent(AnnoRequestMapping.class)){
                        String value = method.getAnnotation(AnnoRequestMapping.class).value();
                        handleMap.put(rootPath+value,method);
                        handleMapController.put(rootPath+value,instance);
                    }
                }
            }

        }

    }

    private void iocDI() {
        //依赖注入:
        for(Map.Entry<String,Object>entry:beans.entrySet()){
            //如果bean上的Field有声明@Qualifier注解:
            try{
                Object instance = entry.getValue();
                Field[] fields = instance.getClass().getDeclaredFields();
                for(Field field:fields){
                    field.setAccessible(true);
                    if(field.isAnnotationPresent(AnnoQualifier.class)){
                        //取得Qualifier注解的value:
                        String key = field.getAnnotation(AnnoQualifier.class).value();
                        //取得注入的实例
                        Object iocBeanInstance = beans.get(key);
                        field.set(instance,iocBeanInstance);
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    private void instance() {
        try{
            for(String className:classNames){
                Class<?>cls = Class.forName(className);
                if(cls.isAnnotationPresent(AnnoController.class)){
                    Object instance = cls.newInstance();
                    beans.put(instance.getClass().getName(),instance);
                }else if(cls.isAnnotationPresent(AnnoService.class)){
                    Object instance = cls.newInstance();
                    AnnoService annoService = cls.getAnnotation(AnnoService.class);
                    String key  =annoService.value();
                    beans.put(key,instance);

                }else{

                }


            }

        }catch (Exception e){
            e.printStackTrace();;
        }

    }




    private void scanPackage(String basePackageName) {
        String replace = basePackageName.replaceAll("\\.", "/");
        //得到com.nd.x 这个文件夹的路径
        String fileDirectory = this.getClass().getResource("/" + replace).getFile();
        //得到这个文件下所有的文件,非绝对路径
        String[] list = new File(fileDirectory).list();
        for(String path:list){
            File file = new File(fileDirectory+path);
            if( file.isDirectory()){
                scanPackage(basePackageName+"."+path);
            }else{
                classNames.add(basePackageName+"."+path.replaceAll(".class",""));
            }

        }


    }
}
