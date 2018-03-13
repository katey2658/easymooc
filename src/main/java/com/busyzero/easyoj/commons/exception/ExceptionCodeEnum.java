package com.busyzero.easyoj.commons.exception;

/**
 * 异常枚举
 * @author katey2658
 */
public enum ExceptionCodeEnum {
    VERIFICATION_NOT_FOUND(8101,"验证编码实例不存在"),
    VERIFICATION_ERROR_INPUT(8102,"验证码输入错误"),
    VERIFICATION_ERROR_INPUT_MAX(8103,"验证码错误达到最大次数"),
    VERIFICATION_ERROR_OVERTIME(8104,"验证码已经失效"),

    ACCOUNT_INFO_NOT_FOUND(8201,"账户信息不存在"),
    ACCOUNT_INFO_EMAIL_NOT_EQUAL(8202,"账户信息中注册邮箱不符合"),
    ACCOUNT_INFO_PARAMETER_ERROR(8203,"参数校验失败或不合法"),

    MAIL_SEND_ERROR(8301,"邮件发送失败")
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
