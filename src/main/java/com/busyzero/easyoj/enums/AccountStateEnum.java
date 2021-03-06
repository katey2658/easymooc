package com.busyzero.easyoj.enums;

/**
 * 账户状态枚举
 * @author 11456
 */
public enum AccountStateEnum {
    STATE_NORMAL(0,"正常"),
    STATE_WAIT_ACTIVATE(1,"等待激活"),
    STATE_DELETE(2,"注销"),
    STATE_FREEZE(3,"冻结")
    ;

    /**状态码*/
    private short state;

    /**状态信息*/
    private String message;

    /**
     * 构造器
     * @param state
     * @param message
     */
    AccountStateEnum(int state, String message) {
        this.state = (short)state;
        this.message = message;
    }

    public short getState() {
        return state;
    }

    public void setState(short state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
