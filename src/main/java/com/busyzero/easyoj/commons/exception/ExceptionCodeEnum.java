package com.busyzero.easyoj.commons.exception;

/**
 * 异常枚举
 * @author katey2658
 */
public enum ExceptionCodeEnum {
    ;

    /**错误码*/
    private Integer errorCode;

    /**错误信息*/
    private String errorMessage;

    /**
     * 构造器
     * @param errorCode
     * @param errorMessage
     */
    ExceptionCodeEnum(Integer errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "ExceptionCodeEnum{" +
                "errorCode=" + errorCode +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
