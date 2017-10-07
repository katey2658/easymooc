package com.busyzero.easyoj.enums;

/**
 * 题目状态枚举
 * @author 11456
 */
public enum QuizItemStateEnum {
    STATE_UNDER_REVIEW(1,"审核中"),
    STATE_NORMAL(2,"正常"),
    STATE_ABANDONED(3,"废弃"),
    STATE_FREEZE(4,"冻结")
    ;
    /**状态码*/
    private short state;

    /**状态信息*/
    private String message;

    QuizItemStateEnum(int state, String message) {
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
