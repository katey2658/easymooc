package com.busyzero.easyoj.dto;

import com.busyzero.easyoj.enums.CatalogOperateEnum;

/**
 * 课程目录信息操作结果
 * @author katey2658
 */
public class CatalogOperateResult<T> {
    /**课程目录操作类型*/
    private CatalogOperateEnum operateEnum;

    /**操作是否成功*/
    private Boolean success;

    /**操作的课程目录对象*/
    private T data;

    /**失败时候的的错误内容*/
    private String errorMessage;

    /**
     * 只是简单的知道成功还是失败
     * @param operateEnum
     * @param success
     */
    public CatalogOperateResult(CatalogOperateEnum operateEnum, Boolean success) {
        this.operateEnum = operateEnum;
        this.success = success;
    }

    /**
     * 操作成功时候,需要返回携带数据
     * @param operateEnum
     * @param success
     * @param data
     */
    public CatalogOperateResult(CatalogOperateEnum operateEnum, Boolean success, T data) {
        this.operateEnum = operateEnum;
        this.success = success;
        this.data = data;
    }

    /**
     * 当操作不成功的时候,出现的错误提示
     * @param operateEnum
     * @param success
     * @param errorMessage
     */
    public CatalogOperateResult(CatalogOperateEnum operateEnum, Boolean success, String errorMessage) {
        this.operateEnum = operateEnum;
        this.success = success;
        this.errorMessage = errorMessage;
    }

    public CatalogOperateEnum getOperateEnum() {
        return operateEnum;
    }

    public void setOperateEnum(CatalogOperateEnum operateEnum) {
        this.operateEnum = operateEnum;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
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
