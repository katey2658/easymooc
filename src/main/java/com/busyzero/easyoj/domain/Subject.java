package com.busyzero.easyoj.domain;

import java.time.Instant;
import java.util.List;

/**
 * 学科实体类
 * Created by 11456 on 2017/7/2.
 */
public class Subject {
    /**学科编号*/
    private Short subjectId;

    /**学科名字*/
    private String subjectName;

    /**专业编号*/
    private Short catalogId;

    /**创建时间*/
    private Instant gmtCreate;

    /**上一次修改时间*/
    private Instant gmtModified;

    /**课程列表:首先显示在六条以内*/
    private List<Course> courseList;

    public Short getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Short subjectId) {
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

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectId=" + subjectId +
                ", subjectName='" + subjectName + '\'' +
                ", catalogId=" + catalogId +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", courseList=" + courseList +
                '}';
    }
}
