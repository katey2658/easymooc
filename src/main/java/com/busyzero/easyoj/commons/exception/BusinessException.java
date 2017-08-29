package com.busyzero.easyoj.commons.exception;

/**
 * 业务异常
 * @author katey2658
 */
public class BusinessException extends RuntimeException{

    /**错误编码*/
    private Integer errorCode;

    /**错误信息*/
    private String errorMessage;

    /**
     * 构造器 自定义异常码
     * @param cause 异常实例
     * @param errorCode 异常码
     */
    public BusinessException(Throwable cause, Integer errorCode) {
        super(cause);
        this.errorCode = errorCode;
        this.errorMessage = cause.getMessage();
    }

    /**
     * 构造器： 根据异常码枚举实例
     * @param codeEnum
     */
    public BusinessException(ExceptionCodeEnum codeEnum) {
        this.errorCode = codeEnum.getErrorCode();
        this.errorMessage = codeEnum.getErrorMessage();
    }

    /**
     * 构造器
     * @param codeEnum 枚举实例 提供异常码
     * @param errorMessage  自定义异常消息
     */
    public BusinessException(ExceptionCodeEnum codeEnum,String errorMessage) {
        this.errorCode = codeEnum.getErrorCode();
        this.errorMessage = errorMessage;
    }

    /**
     * 构造器：有参
     * @param codeEnum 异常码枚举实例
     * @param throwable 异常实例
     */
    public BusinessException(ExceptionCodeEnum codeEnum,Throwable throwable){
        this.errorCode = codeEnum.getErrorCode();
        this.errorMessage = throwable.getMessage();
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
        return "BusinessException{" +
                "errorCode=" + errorCode +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
