package com.busyzero.easyoj.entity;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

/**
 * 用户账户信息表
 * Created by 11456 on 2017/6/22.
 */
@Alias("accountInfo")
public class AccountInfo implements Serializable {
    private static final long serialVersionUID = 78878676127816778L;

    /**账户编号*/
    private Integer accountId;

    /**用户账号:可以修改*/
    private String accountNo;

    /**用户手机号*/
    private String mobile;

    /**邮箱地址*/
    private String emailAddress;

    /** 账户类型 1:学生  2：教师 */
    private String accountType;

    /**密码：MD5加密*/
    private String password;

    /**用户性别:0 无 1男 2女*/
    private Integer gender;

    /**用户年龄*/
    private Integer age;

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
    private Integer accountState;

    /**会员等级*/
    private Integer accountLevel;

    /**地址*/
    private Integer address;

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

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
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

    public Integer getAccountState() {
        return accountState;
    }

    public void setAccountState(Integer accountState) {
        this.accountState = accountState;
    }

    public Integer getAccountLevel() {
        return accountLevel;
    }

    public void setAccountLevel(Integer accountLevel) {
        this.accountLevel = accountLevel;
    }

    public Integer getAddress() {
        return address;
    }

    public void setAddress(Integer address) {
        this.address = address;
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
        return "AccountInfo{" +
                "accountId=" + accountId +
                ", accountNo='" + accountNo + '\'' +
                ", mobile='" + mobile + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", accountType='" + accountType + '\'' +
                ", password='" + password + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", profession='" + profession + '\'' +
                ", institution='" + institution + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", accountPhoto='" + accountPhoto + '\'' +
                ", accountState=" + accountState +
                ", accountLevel=" + accountLevel +
                ", address=" + address +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", authorities=" + authorities +
                '}';
    }
}
