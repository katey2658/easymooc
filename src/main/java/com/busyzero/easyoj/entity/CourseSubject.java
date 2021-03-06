package com.busyzero.easyoj.entity;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

/**
 * <Description>学科实体类</Description>
 * @author katey2658
 * Created by 11456 on 2017/7/2.
 */
@Alias("courseSubject")
public class CourseSubject implements Serializable {
    private static final long serialVersionUID = 78878676127816780L;

    /**学科编号*/
    private Integer subjectId;

    /**学科名字*/
    private String subjectName;

    /**专业编号*/
    private Short catalogId;

    /**学科描述*/
    private String subjectDesc;

    /**创建时间*/
    private Instant gmtCreate;

    /**上一次修改时间*/
    private Instant gmtModified;

    /** 删除标志 */
    private Integer delFlag;

    /**课程列表:首先显示在六条以内*/
    private List<CourseInfo> courseList;

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Short getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(Short catalogId) {
        this.catalogId = catalogId;
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

    public List<CourseInfo> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<CourseInfo> courseList) {
        this.courseList = courseList;
    }

    public String getSubjectDesc() {
        return subjectDesc;
    }

    public void setSubjectDesc(String subjectDesc) {
        this.subjectDesc = subjectDesc;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public String toString() {
        return "CourseSubject{" +
                "subjectId=" + subjectId +
                ", subjectName='" + subjectName + '\'' +
                ", catalogId=" + catalogId +
                ", subjectDesc='" + subjectDesc + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", delFlag=" + delFlag +
                ", courseList=" + courseList +
                '}';
    }
}
