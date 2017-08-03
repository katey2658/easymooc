package com.busyzero.easyoj.enums;

/**
 * 课程目录操作枚举选项
 * @author katey2658
 */
public enum CatalogOperateEnum {
    OP_QUERY(1,"目录列表的查询"),
    OP_ADD(2,"账户注册"),
    OP_DELETE(3,"修改密码"),
    OP_UPDATE(4,"注册时候邮箱验证");

    /**状态*/
    private int state;

    /** 信息*/
    private String stateInfo;

    /**
     * 操作类的构造方法
     * @param state
     * @param stateInfo
     */
    CatalogOperateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }
}
