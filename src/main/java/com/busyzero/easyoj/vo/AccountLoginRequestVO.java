package com.busyzero.easyoj.vo;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * <Descrioption>账户登录请求对象</Descrioption>
 * @author katey2658
 * @date 2018-03-11
 */
public class AccountLoginRequestVO implements Serializable {
    public static final long serialVersionUID = -7889278718787821L;

    /** 登录类型：1. 账号 2.手机号 3.邮箱 */
    @NotNull(message = "登录类型不能为空")
    private Integer loginType;

    /** 账户类型 1.学生 2.老师*/
    @NotNull(message = "账户类型不能为空")
    private Integer accountType;

    /** 密码 */
    private String password;

    /** 用户账号 */
    private String accountNo;

    /** 邮箱地址 */
    private String emailAddress;

    /** 手机号 */
    private String mobileNo;

    public void setLoginType(Integer loginType) {
        this.loginType = loginType;
    }

    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public Integer getLoginType() {
        return loginType;
    }

    public Integer getAccountType() {
        return accountType;
    }

    public String getPassword() {
        return password;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    @Override
    public String toString() {
        return "AccountLoginRequestVO{" +
                "loginType=" + loginType +
                ", accountType=" + accountType +
                ", password='" + password + '\'' +
                ", accountNo='" + accountNo + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                '}';
    }
}
