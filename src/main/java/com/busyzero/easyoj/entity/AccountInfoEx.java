package com.busyzero.easyoj.entity;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.time.Instant;

/**
 * <Description>账户信息拓展信息</Description>
 * @author katey2658
 * @date 2018/3/4
 */
@Alias("accountInfoEx")
public class AccountInfoEx implements Serializable {
    private static final long serialVersionUID = -983948732947897L;

    /** 用户拓展表编号 */
    private Integer accountInfoId;

    /** 用户账户编号 */
    private Integer accountId;

    /** 删除标志 */
    private Integer delFlag;

    /** 创建时间 */
    private Instant gmtCreate;

    /** 最后修改时间 */
    private Instant gmtModified;

    public Integer getAccountInfoId() {
        return accountInfoId;
    }

    public void setAccountInfoId(Integer accountInfoId) {
        this.accountInfoId = accountInfoId;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
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
