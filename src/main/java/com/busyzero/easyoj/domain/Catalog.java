package com.busyzero.easyoj.domain;

import org.apache.ibatis.type.Alias;

import java.time.Instant;
import java.util.List;

/**
 * 目录项：
 * 注：这是视频目录的第一级\
 *
 * Created by 11456 on 2017/7/2.
 */
@Alias("catalog")
public class Catalog {

    /**编号*/
    private Short catalogId;

    /**目录项名*/
    private String catalogName;

    /**简单描述*/
    private String catalogDescription;

    /**创建时间*/
    private Instant gmtCreate;

    /**上一次修改时间*/
    private Instant gmtModified;

    /**目录项下二级学科列表:因为不多，所以不要分页*/
    private List<Subject> subjectList;

    public Short getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(Short catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getCatalogDescription() {
        return catalogDescription;
    }

    public void setCatalogDescription(String catalogDescription) {
        this.catalogDescription = catalogDescription;
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

    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<Subject> subjectList) {
        this.subjectList = subjectList;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "catalogId=" + catalogId +
                ", catalogName='" + catalogName + '\'' +
                ", catalogDescription='" + catalogDescription + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", subjectList=" + subjectList +
                '}';
    }
}
