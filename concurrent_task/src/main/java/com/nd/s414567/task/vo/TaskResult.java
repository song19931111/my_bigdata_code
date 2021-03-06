package com.nd.s414567.task.vo;

/**
 * describe:
 *
 * @author nd.414567
 * @date 2018/07/19
 */
public class TaskResult<R> {

    /**
     * 方法的类型
     */

    private final TaskResultType resultType;
    /**
     * //返回方法的业务结果
     */
    private final R returnValue;

    /**
     * 返回失败的原因:
     */
    private final String reason;


    public TaskResult(TaskResultType resultType, R returnValue, String reason) {
        this.resultType = resultType;
        this.returnValue = returnValue;
        this.reason = reason;
    }
    public TaskResult(TaskResultType resultType, R returnValue) {
        this.resultType = resultType;
        this.returnValue = returnValue;
        this.reason = "Success";
    }
    public TaskResultType getResultType() {
        return resultType;
    }

    public R getReturnValue() {
        return returnValue;
    }



    public String getReason() {
        return reason;
    }
}
