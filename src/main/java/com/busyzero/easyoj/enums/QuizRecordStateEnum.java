package com.busyzero.easyoj.enums;

/**
 * 测试记录状态枚举
 * @author 11456
 */
public enum QuizRecordStateEnum {
    STATE_TESTING(1,"测试中"),
    STATE_END_NORMAL(2,"正常结束"),
    STATE_OVERTIME(3,"超时"),
    STATE_EXIT_WITH_EXCEPTION(4,"异常退出"),
    STATE_NOT_BEGIN(5,"还没有开始")
    ;
    /**状态码*/
    private short state;

    /**状态信息*/
    private String message;

    QuizRecordStateEnum(int state, String message) {
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
