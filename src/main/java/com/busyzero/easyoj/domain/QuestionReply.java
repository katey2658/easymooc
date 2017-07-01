package com.busyzero.easyoj.domain;

import java.time.Instant;

/**
 * 课程问题的回答
 * Created by 11456 on 2017/6/22.
 */
public class QuestionReply {
    /**问题编号*/
    private Long questionReplyId;

    /**课程ID*/
    private Integer courseId;

    /**问题内容*/
    private String questionContent;

    /**问题解答*/
    private String reply;

    /**创建时间*/
    private Instant gmtCreate;

    /**最后修改时间*/
    private Instant gmtModified;

    public Long getQuestionReplyId() {
        return questionReplyId;
    }

    public void setQuestionReplyId(Long questionReplyId) {
        this.questionReplyId = questionReplyId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
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
        return "QuestionReply{" +
                "questionReplyId=" + questionReplyId +
                ", courseId=" + courseId +
                ", questionContent='" + questionContent + '\'' +
                ", reply='" + reply + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }
}
