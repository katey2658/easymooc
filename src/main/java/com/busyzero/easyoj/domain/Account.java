package com.busyzero.easyoj.domain;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

/**
 * 用户账户信息表
 * Created by 11456 on 2017/6/22.
 */
@Alias("account")
public class Account implements Serializable {

    /**账户id*/
    private Integer accountId;

    /**用户账号:可以修改*/
    private String accountNo;

    /**用户手机号*/
    private String mobile;

    /**邮箱地址*/
    private String emailAddress;

    /** 账户类型 1:学生  2：教师*/
    private String accountType;

    /**密码*/
    private String password;

    /**用户性别:0 无 1男 2女*/
    private Short gender;

    /**用户年龄*/
    private Short age;

    /** 职业*/
    private String profession;

    /**工作机构*/
    private String institution;

    /**名字*/
    private String firstName;

    /**姓氏*/
    private String lastName;

    /**用户账户头像：如果没有设置，会选用默认的*/
    private String accountPhoto;

    /**账户状态： 0：正常  1.等待激活  2.注销  3.冻结 */
    private Short accountState;

    /**会员等级*/
    private String accountLevel;

    /**地址编码*/
    private Integer addressCode;

    /**创建时间*/
    private Instant gmtCreate;

    /**最后一次修改时间*/
    private Instant gmtModified;

    /**用户权限*/
    private List<String> authorities;

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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Short getGender() {
        return gender;
    }

    public void setGender(Short gender) {
        this.gender = gender;
    }

    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
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

    public String getAccountPhoto() {
        return accountPhoto;
    }

    public void setAccountPhoto(String accountPhoto) {
        this.accountPhoto = accountPhoto;
    }

    public Short getAccountState() {
        return accountState;
    }

    public void setAccountState(Short accountState) {
        this.accountState = accountState;
    }

    public String getAccountLevel() {
        return accountLevel;
    }

    public void setAccountLevel(String accountLevel) {
        this.accountLevel = accountLevel;
    }

    public Integer getAddressCode() {
        return addressCode;
    }

    public void setAddressCode(Integer addressCode) {
        this.addressCode = addressCode;
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

    public List<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<String> authorities) {
        this.authorities = authorities;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", accountNo='" + accountNo + '\'' +
                ", mobile='" + mobile + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", accountType='" + accountType + '\'' +
                ", password='" + password + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", profession='" + profession + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", accountPhoto='" + accountPhoto + '\'' +
                ", accountState=" + accountState +
                ", accountLevel='" + accountLevel + '\'' +
                ", addressCode=" + addressCode +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", authorities=" + authorities +
                '}';
    }
}
