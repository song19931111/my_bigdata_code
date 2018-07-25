package com.nd.s414567.task.vo;

/**
 * describe:
 *
 * @author nd.414567
 * @date 2018/07/19
 */
public class TaskResult<R> {

    /**
     * ����������
     */

    private final TaskResultType resultType;
    /**
     * //���ط�����ҵ����
     */
    private final R returnValue;

    /**
     * ����ʧ�ܵ�ԭ��:
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