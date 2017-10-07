package com.busyzero.easyoj.enums;

/**
 * 测试类型枚举
 * @author 11456
 */
public enum QuizItemTypeEnum {
    TYPE_SINGLE(1,"单选题"),
    TYPE_MULTIPLE(2,"多选题"),
    TYPE_COMPLETE(3,"填空题"),
    TYPE_RESUME(4,"简述题"),
    TYPE_SYNTHESIS(5,"综合题"),
    TYPE_ATTACH(6,"附加题")
    ;

    /**类型编码*/
    private short type;

    /**状态信息*/
    private String message;

    QuizItemTypeEnum(int type, String message) {
        this.type = (short)type;
        this.message = message;
    }

    public short getType() {
        return type;
    }

    public void setType(short type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
