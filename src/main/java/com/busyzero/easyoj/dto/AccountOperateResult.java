package com.busyzero.easyoj.dto;
import com.busyzero.easyoj.enums.AccountOperateEnum;

/**
 * 账户操作结果传输对象
 * Created by 11456 on 2017/6/23.
 */
public class AccountOperateResult {
    /**账户操作类型*/
    private AccountOperateEnum operateEnum;

    /**操作是否成功*/
    private Boolean isSuccess;

    /**操作的账户对象*/
    private Object data;

    /**失败时候的的错误内容*/
    private String errorMessage;

    /**
     * 只是简单的知道成功还是失败
     * @param operateEnum
     * @param isSuccess
     */
    public AccountOperateResult(AccountOperateEnum operateEnum, Boolean isSuccess) {
        this.operateEnum = operateEnum;
        this.isSuccess = isSuccess;
    }

    /**
     * 操作成功时候,需要返回携带数据
     * @param operateEnum
     * @param isSuccess
     * @param data
     */
    public AccountOperateResult(AccountOperateEnum operateEnum, Boolean isSuccess, Object data) {
        this.operateEnum = operateEnum;
        this.isSuccess = isSuccess;
        this.data = data;
    }

    /**
     * 当操作不成功的时候,出现的错误提示
     * @param operateEnum
     * @param isSuccess
     * @param errorMessage
     */
    public AccountOperateResult(AccountOperateEnum operateEnum, Boolean isSuccess, String errorMessage) {
        this.operateEnum = operateEnum;
        this.isSuccess = isSuccess;
        this.errorMessage = errorMessage;
    }

    public AccountOperateEnum getOperateEnum() {
        return operateEnum;
    }

    public void setOperateEnum(AccountOperateEnum operateEnum) {
        this.operateEnum = operateEnum;
    }

    public Boolean getSuccess() {
        return isSuccess;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
