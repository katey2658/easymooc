package com.busyzero.easyoj.entity;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

/**
 * <Description>目录项：注：这是视频目录的第一级</Description>
 * @author katey2658
 * @date 2017/7/2.
 */
@Alias("courseCatalog")
public class CourseCatalog implements Serializable{
    private static final long serialVersionUID = 78878676127816779L;

    /**编号*/
    private Integer catalogId;

    /**目录项名*/
    private String catalogName;

    /**简单描述*/
    private String catalogDesc;

    /**创建时间*/
    private Instant gmtCreate;

    /**上一次修改时间*/
    private Instant gmtModified;

    /** 删除标志 0 正常 1: 删除 */
    private Integer delFlag;

    /**目录项下二级学科列表:因为不多，所以不要分页*/
    private List<CourseSubject> subjectList;

    public Integer getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(Integer catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getCatalogDesc() {
        return catalogDesc;
    }

    public void setCatalogDesc(String catalogDesc) {
        this.catalogDesc = catalogDesc;
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

    public List<CourseSubject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<CourseSubject> subjectList) {
        this.subjectList = subjectList;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public String toString() {
        return "CourseCatalog{" +
                "catalogId=" + catalogId +
                ", catalogName='" + catalogName + '\'' +
                ", catalogDesc='" + catalogDesc + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", delFlag=" + delFlag +
                ", subjectList=" + subjectList +
                '}';
    }
}
