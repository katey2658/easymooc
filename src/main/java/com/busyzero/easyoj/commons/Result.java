package com.busyzero.easyoj.commons;

import java.io.Serializable;

/**
 * 用户统一返回的对象
 * @author katey2658
 * @param <T> 数据传输对象的泛型
 */
public class Result<T> implements Serializable{
    private static final long serialVersionUID = 7247714666080613254L;

    /**是否成功*/
    private Boolean success;

    /**错误码*/
    private Integer errorCode;

    /**结果对象*/
    private T resultObj;

    /**结果信息*/
    private String resultMessage = "";

    /**
     * 失败无参
     */
    public void fail(){
        this.success = false;
    }

    /**
     * 失败有参
     * @param errorCode 错误编码
     * @param resultMessage 结果信息
     */
    public void fail(Integer errorCode,String resultMessage){
        this.success = false;
        this.errorCode = errorCode;
        this.resultMessage = resultMessage;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public T getResultObj() {
        return resultObj;
    }

    public void setResultObj(T resultObj) {
        this.resultObj = resultObj;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    @Override
    public String toString() {
        return "Result{" +
                "success=" + success +
                ", errorCode=" + errorCode +
                ", resultObj=" + resultObj +
                ", resultMessage='" + resultMessage + '\'' +
                '}';
    }
}
