package com.busyzero.easyoj.enums;

/**
 * 课程申请状态枚举
 * @author 11456
 */
public enum CourseJoinRecordStateEnum {
    STATE_INVALID(0,"无效"),
    STATE_APPLYING(1,"申请中"),
    STATE_APPLY_REFUSED(2,"申请不通过"),
    STATE_APPLY_PASS(3,"申请通过"),
    STATE_WAITING_PAY(4,"等待支付"),
    STATE_PAY_SUCCESS(5,"支付成功")
    ;
    /**状态码*/
    private short state;

    /**状态信息*/
    private String message;

    CourseJoinRecordStateEnum(int state, String message) {
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
