package com.nd.s414567.task.vo;

/**
 * describe:������������Ҫʵ�ֵĽӿ�
 *
 * @author nd.414567
 * @date 2018/07/19
 */
public interface ITaskProcessor<T,R>{

    TaskResult<R> executeTask(T data);
}
