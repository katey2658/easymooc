package com.busyzero.easyoj.entity;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.time.Instant;

/**
 * <Description>用户权限记录</Description>
 * @author katey2658
 * @date 2018/3/4
 */
@Alias("accountAuthority")
public class AccountAuthority implements Serializable{
    private static final long serialVersionUID = -989718723817787L;

    /** 权限记录编号 */
    private Long authorityId;

    /** 用户编号 */
    private Integer accountId;

    /** 用户账号 */
    private String accountNo;

    /** 用户权限 */
    private String authority;

    /** 默认有效 */
    private Boolean active;

    /** 删除标志 */
    private Integer delFlag;

    /** 创建时间 */
    private Instant gmtCreate;

    /** 最后修改时间 */
    private Instant gmtModified;

    public Long getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(Long authorityId) {
        this.authorityId = authorityId;
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

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
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
