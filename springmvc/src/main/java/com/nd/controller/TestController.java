package com.nd.controller;

import com.nd.Service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.Callable;

/**
 * describe:
 *
 * @author nd.414567
 * @date 2018/07/03
 */

@Controller
public class TestController {

    @Autowired
    TestService testService;

    @ResponseBody
    @RequestMapping("/order")
    public String order(){
        return testService.order();
    }

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
    @RequestMapping("/quotes")
    @ResponseBody
    public DeferredResult<String> quotes() {
        DeferredResult<String> deferredResult = new DeferredResult<String>();
        // Save the deferredResult somewhere..
        return deferredResult;
    }



    /**
     * 异步线程
     */
    @ResponseBody
    @RequestMapping("order01")

    //到子线程中，Spring会重新派发一次容器
    public Callable<String> order01() {

        /*
           返回的时候，会再一次请求web容器，所以拦截器会被执行两次
         */

        System.out.println("主线程"+Thread.currentThread()+System.currentTimeMillis());
        return new Callable<String>() {
            public String call() throws Exception {
                System.out.println("子线程"+Thread.currentThread()+System.currentTimeMillis()+"start");
                Thread.sleep(5000);
                System.out.println("子线程"+Thread.currentThread()+System.currentTimeMillis()+"stop");
                //返回到页面的内容
                return "hello";

            }
        };

    }

    @ResponseBody
    @RequestMapping("/orderSave")


    public DeferredResult<Object> order02() {
        //等待5000ms
        DeferredResult<Object> deferredResult = new DeferredResult<Object>(5000L,"create failed");

        DeferredQueue.save(deferredResult);
        return  deferredResult;
    }


    @ResponseBody
    @RequestMapping("/orderTake")


    public String order03() {


        DeferredResult<Object> deferredResult = DeferredQueue.get();
        if(deferredResult==null){
            return "队列为空";
        }
        //模拟返回的结果
        deferredResult.setResult("success");
        return "get order success";

    }



}
