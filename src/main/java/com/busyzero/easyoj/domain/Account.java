package com.busyzero.easyoj.domain;

import org.apache.ibatis.type.Alias;

import java.time.Instant;

/**
 * 用户账户信息表
 * Created by 11456 on 2017/6/22.
 */
@Alias("account")
public class Account {

    /**账户id*/
    private Integer accountId;

    /**名字*/
    private String firstName;

    /**姓氏*/
    private String lastNmae;

    /**邮箱地址*/
    private String emailAddress;

    /**密码*/
    private String password;

    /**创建时间*/
    private Instant gmtCreate;

    /**最后一次修改时间*/
    private Instant gmtModified;

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastNmae() {
        return lastNmae;
    }

    public void setLastNmae(String lastNmae) {
        this.lastNmae = lastNmae;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
}
