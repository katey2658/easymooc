package com.busyzero.easyoj.enums;

/**
 * 测试类型枚举
 * @author 11456
 */
public enum  QuizTypeEnum {
    TYPE_UNIT_TEST(1,"单元测试"),
    TYPE_STAGE_TEST(2,"阶段测试"),
    TYPE_SYNTHESIS_TEST(3,"综合测试"),
    TYPE_QUESTIONNAIRE_TEST(4,"问卷测试")
    ;

    /**类型编码*/
    private short type;

    /**状态信息*/
    private String message;

    QuizTypeEnum(int type, String message) {
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
