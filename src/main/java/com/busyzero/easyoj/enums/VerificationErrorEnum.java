package com.busyzero.easyoj.enums;

public enum  VerificationErrorEnum {
    ERROR_ORIGIN_CODE_NULL(501,"会话中没有存在状态码"),
    ERROR_CODE_NULL(502,"输入的为null"),
    ERROR_CODE_EMPTY(503,"输入不能为空"),
    ERROR_CODE_NOT_EQUAL(504,"输入不符合");

    /**状态码*/
    private int stateCode;

    /** 状态信息*/
    private String stateInfo;

    /**
     * 构造器
     * @param stateCode
     * @param stateInfo
     */
    VerificationErrorEnum(int stateCode,String stateInfo){
        this.stateCode=stateCode;
        this.stateInfo=stateInfo;
    }

    public int getStateCode() {
        return stateCode;
    }

    @Override
    public String toString() {
        return "VerificationErrorEnum{" +
                "stateCode=" + stateCode +
                ", stateInfo='" + stateInfo + '\'' +
                '}';
    }

    public void setStateCode(int stateCode) {
        this.stateCode = stateCode;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }
}
