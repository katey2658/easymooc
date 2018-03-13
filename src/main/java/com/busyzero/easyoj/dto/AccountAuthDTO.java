package com.busyzero.easyoj.dto;

import java.io.Serializable;

/**
 * <Description>账户登录响应消息体</Description>
 * @author katey2658
 * @date 2018-03-11
 */
public class AccountAuthDTO implements Serializable {
    public static final long serialVersionUID = -787178278676677L;

    /** 账户类型 1.学生 2.老师*/
    private Integer accountType;

    /** 账户编号 */
    private Integer accountId;

    /** 用户账号 */
    private String accountNo;

    /** 邮箱地址 */
    private String emailAddress;

    /** 手机号 */
    private String mobileNo;

    /** 认证字符串 */
    private String authToken;

    /** 账户名 first_name +  last_name*/
    private String accountName;

    /** 账户级别 */
    private Integer accountLevel;

    public Integer getAccountType() {
        return accountType;
    }

    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Integer getAccountLevel() {
        return accountLevel;
    }

    public void setAccountLevel(Integer accountLevel) {
        this.accountLevel = accountLevel;
    }

    @Override
    public String toString() {
        return "AccountAuthDTO{" +
                "accountType=" + accountType +
                ", accountId=" + accountId +
                ", accountNo='" + accountNo + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", authToken='" + authToken + '\'' +
                ", accountName='" + accountName + '\'' +
                ", accountLevel=" + accountLevel +
                '}';
    }
}
