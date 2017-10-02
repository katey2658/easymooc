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
    /**账户状态： 0：正常  1.等待激活  2.注销  3.冻结 */

    /**错误码*/
    private Integer state;

    /**错误信息*/
    private String message;

    AccountStateEnum(Integer state, String message) {
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
