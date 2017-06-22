package com.busyzero.easyoj.domain;

import java.time.Instant;

/**
 * 已经参加课程的信息
 * Created by 11456 on 2017/6/22.
 */
public class CourseJoin {
    /**记录编号*/
    private Long courseJoinId;

    /**已经参加课程ID*/
    private Integer courseId;

    /**用户编号*/
    private Integer accountId;

    /**创建时间*/
    private Instant gmtCreate;

    /**最后修改时间*/
    private Instant gmtModified;

    public Long getCourseJoinId() {
        return courseJoinId;
    }

    public void setCourseJoinId(Long courseJoinId) {
        this.courseJoinId = courseJoinId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
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
