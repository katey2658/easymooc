package com.busyzero.easyoj.domain;

import java.time.Instant;

/**
 * 课程评论信息列表
 * Created by 11456 on 2017/6/22.
 */
public class Comment {
    /**评论编号*/
    private Long commentId;

    /**课程编号*/
    private Integer courseId;

    /**用户Id*/
    private Integer accountId;

    /**打分*/
    private Short score;

    /**评论*/
    private String commment;

    /**创建时间*/
    private Instant timeStart;

    /**最后修改时间*/
    private Instant timeModified;

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
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

    public Short getScore() {
        return score;
    }

    public void setScore(Short score) {
        this.score = score;
    }

    public String getCommment() {
        return commment;
    }

    public void setCommment(String commment) {
        this.commment = commment;
    }

    public Instant getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Instant timeStart) {
        this.timeStart = timeStart;
    }

    public Instant getTimeModified() {
        return timeModified;
    }

    public void setTimeModified(Instant timeModified) {
        this.timeModified = timeModified;
    }
}
