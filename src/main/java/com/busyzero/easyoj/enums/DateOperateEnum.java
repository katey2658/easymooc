package com.busyzero.easyoj.enums;

/**
 * 数据操作操作枚举选项
 * @author katey2658
 */
public enum DateOperateEnum {
    OP_QUERY_BATCH(1,"目录列表的获取"),
    OP_QUERY(2,"详细数据的获取"),
    OP_ADD(3,"添加数据记录"),
    OP_ADD_BATCH(4,"批量添加数据记录"),
    OP_DELETE(4,"数据的删除"),
    OP_DELETE_BATCH(5,"数据的批量删除"),
    OP_UPDATE(6,"数据的修改"),
    OP_UPDATE_BATCH(7,"数据的批量修改");

    /**状态*/
    private int state;

    /** 信息*/
    private String stateInfo;

    /**
     * 操作类的构造方法
     * @param state
     * @param stateInfo
     */
    DateOperateEnum(int state, String stateInfo) {
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

    @Override
    public String toString() {
        return "DateOperateEnum{" +
                "state=" + state +
                ", stateInfo='" + stateInfo + '\'' +
                '}';
    }
}
