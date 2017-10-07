package com.busyzero.easyoj.enums;

/**
 * 测试状态枚举
 * @author 11456
 */
public enum  QuizStateEnum {
    STATE_UNDER_REVIEW(1,"审核中"),
    STATE_NORMAL(2,"正常"),
    STATE_NOT_BEGIN(3,"还没有开始"),
    STATE_ABANDONED(4,"废弃"),
    STATE_FREEZE(5,"冻结"),
    STATE_OVERTIME(6,"过期")
    ;
    /**状态码*/
    private short state;

    /**状态信息*/
    private String message;

    QuizStateEnum(int state, String message) {
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
