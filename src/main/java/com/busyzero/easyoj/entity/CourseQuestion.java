package com.busyzero.easyoj.entity;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.time.Instant;

/**
 * <Description>课程问题的回答</Description>
 * @author katey2658
 * @date 2017/6/22.
 */
@Alias("courseQuestion")
public class CourseQuestion implements Serializable {
    private static final long serialVersionUID = 78878676127816785L;

    /**问题编号*/
    private Long questionReplyId;

    /**课程ID*/
    private Integer courseId;

    /**问题内容*/
    private String questionContent;

    /**问题解答*/
    private String reply;

    /** 删除标志 */
    private Integer delFlag;

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

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public String toString() {
        return "CourseQuestion{" +
                "questionReplyId=" + questionReplyId +
                ", courseId=" + courseId +
                ", questionContent='" + questionContent + '\'' +
                ", reply='" + reply + '\'' +
                ", delFlag=" + delFlag +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }
}
