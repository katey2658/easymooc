package com.busyzero.easyoj.enums;

/**
 * 账户操作枚举类型
 * Created by 11456 on 2017/6/23.
 */
public enum  AccountOperateEnum {
    OP_SIGNUP(1,"账户登录操作"),
    OP_SIGNIN(2,"账户注册"),
    OP_PASSWORD_RESET(3,"修改密码"),
    OP_SIGNUPP_ACCESSKEY_CHECK(4,"注册时候邮箱验证");

    /**状态*/
    private int state;

    /** 信息*/
    private String stateInfo;

    /**
     * 全参构造
     * @param state 状态码
     * @param stateInfo 描述
     */
    AccountOperateEnum(int state,String stateInfo){
        this.state=state;
        this.stateInfo=stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    @Override
    public String
    toString() {
        return "AccountOperateEnum{" +
                "state=" + state +
                ", stateInfo='" + stateInfo + '\'' +
                '}';
    }
}
