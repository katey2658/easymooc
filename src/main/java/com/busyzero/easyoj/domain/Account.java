package com.busyzero.easyoj.domain;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.time.Instant;

/**
 * 用户账户信息表
 * Created by 11456 on 2017/6/22.
 */
@Alias("account")
public class Account implements Serializable {

    /**账户id*/
    private Integer accountId;

    /**名字*/
    private String firstName;

    /**姓氏*/
    private String lastName;

    /**邮箱地址*/
    private String emailAddress;

    /**用户账户头像：如果没有设置，会选用默认的*/
    private String accountPhoto;

    /**密码*/
    private String password;

    /**是否有效*/
    private Boolean alive;

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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getAccountPhoto() {
        return accountPhoto;
    }

    public void setAccountPhoto(String accountPhoto) {
        this.accountPhoto = accountPhoto;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getAlive() {
        return alive;
    }

    public void setAlive(Boolean alive) {
        this.alive = alive;
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
        return "Account{" +
                "accountId=" + accountId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", accountPhoto='" + accountPhoto + '\'' +
                ", password='" + password + '\'' +
                ", alive=" + alive +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }
}
