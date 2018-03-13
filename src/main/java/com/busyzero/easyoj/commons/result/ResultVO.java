package com.busyzero.easyoj.commons.result;

import com.busyzero.easyoj.commons.constants.ErrorCode;
import com.busyzero.easyoj.commons.exception.BusinessException;
import com.busyzero.easyoj.commons.exception.ExceptionCodeEnum;

import java.io.Serializable;

/**
 * <Desription>用户统一返回的对象</Desription>
 * @author katey2658
 * @param <T> 数据传输对象的泛型
 */
public class ResultVO<T> implements Serializable{
    public static final long serialVersionUID = 7247714666080613254L;

    /**是否成功*/
    private Boolean success;

    /**错误码*/
    private Integer errorCode;

    /**结果对象*/
    private T resultObj;

    /**结果信息*/
    private String resultMessage ;

    public ResultVO() {
        super();
        init();
    }

    /**
     *  初始化对象数据
     */
    private void init(){
        this.success = Boolean.TRUE;
        this.errorCode = ErrorCode.CODE_SUCCESS;
        this.resultMessage = "";
    }

    /**
     * 失败无参
     */
    public void fail(){
        this.success = Boolean.FALSE;
    }

    /**
     * 失败有参
     * @param errorCode 错误编码
     * @param resultMessage 结果信息
     */
    public void fail(Integer errorCode,String resultMessage){
        this.success = Boolean.FALSE;
        this.errorCode = errorCode;
        this.resultMessage = resultMessage;
    }

    /**
     * 通过业务异常对象设置错误信息
     * @param exception
     */
    public void fail(BusinessException exception){
        this.success = Boolean.FALSE;
        this.errorCode = exception.getErrorCode();
        this.resultMessage = exception.getErrorMessage();
    }

    /**
     * 通过业务异常对象设置错误信息
     * @param codeEnum
     */
    public void fail(ExceptionCodeEnum codeEnum){
        this.success = Boolean.FALSE;
        this.errorCode = codeEnum.getErrorCode();
        this.resultMessage = codeEnum.getErrorMessage();
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
        return "ResultVO{" +
                "success=" + success +
                ", errorCode=" + errorCode +
                ", resultObj=" + resultObj +
                ", resultMessage='" + resultMessage + '\'' +
                '}';
    }
}
