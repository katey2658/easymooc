package com.busyzero.easyoj.enums;

/**
 * 数据信息操作错误枚举
 * @author katey2658
 */
public enum  DataOperateErrorEnum {
    PARAMETER_IS_NULL(100,"参数值为空"),
    PARAMETER_OUT_BOUNDS(101,"参数值超出范围"),
    PARAMETER_TYPE_NOT_EXPECTED(102,"参数类型不匹配"),
    DATA_RESULT_IS_NULL(103,"请求到的值为空"),
    DATE_GET_EXCEPTION(104,"数据获取异常");

    /**状态*/
    private int stateCode;

    /** 信息*/
    private String errorInfo;

    /**
     * 操作类的构造方法
     * @param stateCode
     * @param errorInfo
     */
    DataOperateErrorEnum(int stateCode, String errorInfo) {
        this.stateCode = stateCode;
        this.errorInfo = errorInfo;
    }

    public int getStateCode() {
        return stateCode;
    }

    public void setStateCode(int stateCode) {
        this.stateCode = stateCode;
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }

    @Override
    public String toString() {
        return "DataOperateErrorEnum{" +
                "stateCode=" + stateCode +
                ", errorInfo='" + errorInfo + '\'' +
                '}';
    }
}
