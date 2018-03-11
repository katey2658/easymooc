package com.busyzero.easyoj.entity;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

/**
 * <Description>用户购买课程记录表</Description>
 * @author katey2658
 * @date 2017/7/4.
 */
@Alias("courseJoinRecord")
public class CourseJoinRecord implements Serializable {
    private static final long serialVersionUID = 78878676127816784L;

    /**用户购买记录编号*/
    private Long recordId;

    /**用户编号*/
    private Integer accountId;

    /**课程编号*/
    private Integer courseId;

    /**状态:0.无效  1.申请中  2.申请被拒绝  3.申请通过  4.等待支付 5.支付成功 */
    private Integer recordState;

    /**课程原本价格*/
    private BigDecimal priceCourse;

    /**实际付款*/
    private BigDecimal pricePaidActual;

    /**折扣千分比*/
    private Integer discountPercent;

    /**选择支付方式 1.网银 2.支付宝 3.微信*/
    private Integer methodPaid;

    /**账单编号*/
    private String billCode;

    /**创建时间*/
    private Instant gmtCreate;

    /**最后修改时间:理论上是不允许修改的*/
    private Instant gmtModified;

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getRecordState() {
        return recordState;
    }

    public void setRecordState(Integer recordState) {
        this.recordState = recordState;
    }

    public BigDecimal getPriceCourse() {
        return priceCourse;
    }

    public void setPriceCourse(BigDecimal priceCourse) {
        this.priceCourse = priceCourse;
    }

    public BigDecimal getPricePaidActual() {
        return pricePaidActual;
    }

    public void setPricePaidActual(BigDecimal pricePaidActual) {
        this.pricePaidActual = pricePaidActual;
    }

    public Integer getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(Integer discountPercent) {
        this.discountPercent = discountPercent;
    }

    public Integer getMethodPaid() {
        return methodPaid;
    }

    public void setMethodPaid(Integer methodPaid) {
        this.methodPaid = methodPaid;
    }

    public String getBillCode() {
        return billCode;
    }

    public void setBillCode(String billCode) {
        this.billCode = billCode;
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
        return "CourseJoinRecord{" +
                "recordId=" + recordId +
                ", accountId=" + accountId +
                ", courseId=" + courseId +
                ", recordState=" + recordState +
                ", priceCourse=" + priceCourse +
                ", pricePaidActual=" + pricePaidActual +
                ", discountPercent=" + discountPercent +
                ", methodPaid=" + methodPaid +
                ", billCode='" + billCode + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }
}
