package com.nd.s414567.task.vo;

/**
 * describe:任务结果
 *
 * @author nd.414567
 * @date 2018/07/19
 */
public enum  TaskResultType {
    /**
     * Success：返回了业务需要的结果
     * Failure:返回了错误的结果
     * Exception:方法出现异常
     */
    Success,Failure,Exception;
}
