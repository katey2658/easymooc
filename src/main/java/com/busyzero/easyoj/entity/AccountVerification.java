package com.busyzero.easyoj.entity;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.time.Instant;

/**
 * 用户验证码
 * @author 11456
 */
@Alias("accountVerification")
public class AccountVerification implements Serializable{
    private static final long serialVersionUID = 78878676127816782L;

    /**验证码编号*/
    private Long verificationId;

    /**用户编号*/
    private Integer accountId;

    /**用户账号*/
    private String accountNo;

    /**邮箱地址*/
    private String emailAddress;

    /**手机号*/
    private String mobile;

    /**验证码*/
    private String verificationCode;

    /**错误输入次数*/
    private Integer errorInput;

    /**失效时间:默认保持十五分钟有效*/
    private Instant invalidTime;

    /**验证状态: 0.无效 1.正常 2.超时失效 3.验证*/
    private Short verificationState;

    /**创建时间*/
    private Instant gmtCreate;

    /**上一次修改时间*/
    private Instant gmtModified;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getVerificationId() {
        return verificationId;
    }

    public void setVerificationId(Long verificationId) {
        this.verificationId = verificationId;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
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

    public Integer getErrorInput() {
        return errorInput;
    }

    public void setErrorInput(Integer errorInput) {
        this.errorInput = errorInput;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Instant getInvalidTime() {
        return invalidTime;
    }

    public void setInvalidTime(Instant invalidTime) {
        this.invalidTime = invalidTime;
    }

    public Short getVerificationState() {
        return verificationState;
    }

    public void setVerificationState(Short verificationState) {
        this.verificationState = verificationState;
    }

    public Instant getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Instant gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Instant getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Instant gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Override
    public String toString() {
        return "AccountVerification{" +
                "verificationId=" + verificationId +
                ", accountId=" + accountId +
                ", accountNo='" + accountNo + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", mobile='" + mobile + '\'' +
                ", verificationCode='" + verificationCode + '\'' +
                ", errorInput=" + errorInput +
                ", invalidTime=" + invalidTime +
                ", verificationState=" + verificationState +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }
}
