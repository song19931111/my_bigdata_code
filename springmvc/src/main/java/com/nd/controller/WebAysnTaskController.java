package com.nd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.async.WebAsyncTask;

import java.util.UUID;
import java.util.concurrent.Callable;

/**
 * describe:
 *
 * @author nd.414567
 * @date 2018/07/05
 */
@Controller
public class WebAysnTaskController {



    public WebAsyncTask<Object>orderWeb(){

        Callable <Object>callable = new Callable<Object>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(3000);
                UUID uuid = UUID.randomUUID();
                return uuid.toString();
            }
        };
        WebAsyncTask<Object> webAsyncTask = new WebAsyncTask<>(1000,callable);
        webAsyncTask.onTimeout(new Callable<Object>() {

            @Override
            public Object call() throws Exception {
                return "超时";
            }
        });
        return webAsyncTask;

    }




}
