package com.busyzero.easyoj.entity;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.time.Instant;

/**
 * 课程评论信息列表
 * Created by 11456 on 2017/6/22.
 */
@Alias("courseComment")
public class CourseComment implements Serializable {
    private static final long serialVersionUID = 78878676127816783L;

    /**评论编号*/
    private Long commentId;

    /**课程编号*/
    private Integer courseId;

    /**用户Id*/
    private Integer accountId;

    /**打分*/
    private Short score;

    /**评论*/
    private String commentContent;

    /**创建时间*/
    private Instant timeStart;

    /**最后修改时间*/
    private Instant timeModified;

    /**评论用户信息*/
    private AccountInfo account;

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

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
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

    public AccountInfo getAccount() {
        return account;
    }

    public void setAccount(AccountInfo account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "CourseComment{" +
                "commentId=" + commentId +
                ", courseId=" + courseId +
                ", accountId=" + accountId +
                ", score=" + score +
                ", commentContent='" + commentContent + '\'' +
                ", timeStart=" + timeStart +
                ", timeModified=" + timeModified +
                ", account=" + account +
                '}';
    }
}
