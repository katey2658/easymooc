package com.busyzero.easyoj.dto;

import com.busyzero.easyoj.enums.AccountOperateEnum;
import com.busyzero.easyoj.enums.CatalogOperateEnum;

/**
 * 课程目录信息操作结果
 * @author katey2658
 */
public class CatalogOperateResult<T> {
    /**课程目录操作类型*/
    private CatalogOperateEnum operateEnum;

    /**操作是否成功*/
    private Boolean isSuccess;

    /**操作的课程目录对象*/
    private T data;

    /**失败时候的的错误内容*/
    private String errorMessage;

    /**
     * 只是简单的知道成功还是失败
     * @param operateEnum
     * @param isSuccess
     */
    public CatalogOperateResult(CatalogOperateEnum operateEnum, Boolean isSuccess) {
        this.operateEnum = operateEnum;
        this.isSuccess = isSuccess;
    }

    /**
     * 操作成功时候,需要返回携带数据
     * @param operateEnum
     * @param isSuccess
     * @param data
     */
    public CatalogOperateResult(CatalogOperateEnum operateEnum, Boolean isSuccess, T data) {
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
    public CatalogOperateResult(CatalogOperateEnum operateEnum, Boolean isSuccess, String errorMessage) {
        this.operateEnum = operateEnum;
        this.isSuccess = isSuccess;
        this.errorMessage = errorMessage;
    }

    public CatalogOperateEnum getOperateEnum() {
        return operateEnum;
    }

    public void setOperateEnum(CatalogOperateEnum operateEnum) {
        this.operateEnum = operateEnum;
    }

    public Boolean getSuccess() {
        return isSuccess;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
