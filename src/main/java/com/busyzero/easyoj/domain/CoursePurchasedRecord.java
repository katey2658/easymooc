package com.busyzero.easyoj.domain;

import org.apache.ibatis.type.Alias;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

/**
 * 用户购买课程记录表
 * Created by 11456 on 2017/7/4.
 */
@Alias("coursePurchasedRecord")
public class CoursePurchasedRecord {

    /**用户购买记录编号*/
    private Long coursePurchasedRecordId;

    /**用户编号*/
    private Integer accountId;

    /**课程编号*/
    private Integer courseId;

    /**是否有效:默认是有*/
    private Boolean valid;

    /**是否已经付款:默认是没有*/
    private Boolean paid;

    /**课程原本价格*/
    private BigDecimal priceCourse;

    /**实际付款*/
    private BigDecimal pricePaidActual;

    /**折扣百分比*/
    private Short discountPercent;

    /**支付方式*/
    private Short methodPaid;

    /**账单编号*/
    private String billCode;

    /**创建时间*/
    private Instant gmtCreate;

    /**最后修改时间:理论上是不允许修改的*/
    private Instant gmtModified;

    /**已经购买记录:概念中包含没有付款的*/
    private List<Course> courseList;

    public Long getCoursePurchasedRecordId() {
        return coursePurchasedRecordId;
    }

    public void setCoursePurchasedRecordId(Long coursePurchasedRecordId) {
        this.coursePurchasedRecordId = coursePurchasedRecordId;
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

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
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

    public Short getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(Short discountPercent) {
        this.discountPercent = discountPercent;
    }

    public Short getMethodPaid() {
        return methodPaid;
    }

    public void setMethodPaid(Short methodPaid) {
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
        return "CoursePurchasedRecord{" +
                "coursePurchasedRecordId=" + coursePurchasedRecordId +
                ", accountId=" + accountId +
                ", courseId=" + courseId +
                ", valid=" + valid +
                ", paid=" + paid +
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
