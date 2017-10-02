package com.busyzero.easyoj.enums;


/**
 * 验证状态枚举
 * @author 11456
 */
public enum VerficationStateEnum {
    STATE_INVALID(0,"无效"),
    STATE_NORMAL(1,"正常"),
    STATE_OVERTIME(2,"超时失效"),
    STATE_VALID(3,"已经验证"),
    STATE_ERROR_MAX(4,"上限失效");
    /**错误码*/
    private Integer state;

    /**错误信息*/
    private String message;

    VerficationStateEnum(Integer state, String message) {
        this.state = state;
        this.message = message;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
