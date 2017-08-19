package com.busyzero.easyoj.dto;

import com.busyzero.easyoj.enums.VerificationErrorEnum;

/**
 * 返回结果
 * @param <T>
 */
public class VerificationCodeResult<T> {

    /**操作是否成功*/
    private Boolean successFlag;

    /**返回对象*/
    private T successObj;

    /**错误信息*/
    private VerificationErrorEnum error;

    /**另外附加的消息*/
    public String message;

    /**
     * 提供错误信息
     * @param successFlag
     * @param error
     */
    public VerificationCodeResult(Boolean successFlag, VerificationErrorEnum error){
        this.successFlag = successFlag;
        this.error=error;
    }

    /**
     * 成功最简单接口
     * @param successObj
     */
    public VerificationCodeResult(T successObj){
        this(true,successObj);
    }
    /**
     * 成功信息简写接口
     * @param successFlag
     * @param successObj
     */
    public VerificationCodeResult(Boolean successFlag, T successObj){
        this(successFlag,successObj,"");
    }
    /**
     * 成功提供的构造器
     * @param successFlag
     * @param successObj
     * @param message
     */
    public VerificationCodeResult(Boolean successFlag, T successObj, String message) {
        this.successFlag = successFlag;
        this.successObj = successObj;
        this.message = message;
    }

    public Boolean getSuccessFlag() {
        return successFlag;
    }

    public void setSuccessFlag(Boolean successFlag) {
        this.successFlag = successFlag;
    }

    public T getSuccessObj() {
        return successObj;
    }

    public void setSuccessObj(T successObj) {
        this.successObj = successObj;
    }

    public VerificationErrorEnum getError() {
        return error;
    }

    public void setError(VerificationErrorEnum error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
