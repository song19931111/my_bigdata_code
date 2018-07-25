package com.nd.controller;

import org.springframework.web.context.request.async.DeferredResult;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * describe:
 *
 * @author nd.414567
 * @date 2018/07/03
 */
public class DeferredQueue {
    //队列:
    public static Queue<DeferredResult<Object>> queue = new ConcurrentLinkedDeque<>();

    public static void save(DeferredResult<Object> object){
        queue.add(object);
    }
    public static DeferredResult<Object> get(){
        return queue.poll();
    }
}
