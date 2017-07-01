package com.busyzero.easyoj.domain;

import java.time.Instant;
import java.util.List;

/**
 * 课程信息表
 * Created by 11456 on 2017/6/22.
 */
public class Course {
    /**课程编号*/
    private Integer courseId;

    /**所属学科*/
    private String subject;

    /**课程标题*/
    private String title;

    /**课程概述*/
    private String description;

    /**课程须知*/
    private String condition;

    /**制作方ID*/
    private Integer provierId;

    /**提供方信息*/
    private Provider provider;

    /**教学方Id*/
    private Integer teacherId;

    /** 教学方信息*/
    private Teacher teacher;

    /**课程开始时间*/
    private Instant timeStart;

    /**课程结束时间*/
    private Instant timeEnd;

    /**使用级别*/
    private String level;

    /**每周学习平均时间*/
    private String timePerWeek;

    /**授课语言*/
    private String language;

    /**通过课程条件*/
    private String passCondition;

    /**评分平均分*/
    private Float score_average;

    /**创建时间*/
    private Instant gmtCreate;

    /**最后修改时间*/
    private Instant gmtModified;

    /**课程列表加回答*/
    private List<QuestionReply> questionReplyList;

    /**评论信息列表*/
    private List<Comment>commentList;

    /**授课大纲信息表*/
    private List<WeekTask> weekTaskList;

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Integer getProvierId() {
        return provierId;
    }

    public void setProvierId(Integer provierId) {
        this.provierId = provierId;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Instant getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Instant timeStart) {
        this.timeStart = timeStart;
    }

    public Instant getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Instant timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getTimePerWeek() {
        return timePerWeek;
    }

    public void setTimePerWeek(String timePerWeek) {
        this.timePerWeek = timePerWeek;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPassCondition() {
        return passCondition;
    }

    public void setPassCondition(String passCondition) {
        this.passCondition = passCondition;
    }

    public Float getScore_average() {
        return score_average;
    }

    public void setScore_average(Float score_average) {
        this.score_average = score_average;
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

    public List<QuestionReply> getQuestionReplyList() {
        return questionReplyList;
    }

    public void setQuestionReplyList(List<QuestionReply> questionReplyList) {
        this.questionReplyList = questionReplyList;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public List<WeekTask> getWeekTaskList() {
        return weekTaskList;
    }

    public void setWeekTaskList(List<WeekTask> weekTaskList) {
        this.weekTaskList = weekTaskList;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", subject='" + subject + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", condition='" + condition + '\'' +
                ", provierId=" + provierId +
                ", provider=" + provider +
                ", teacherId=" + teacherId +
                ", teacher=" + teacher +
                ", timeStart=" + timeStart +
                ", timeEnd=" + timeEnd +
                ", level='" + level + '\'' +
                ", timePerWeek='" + timePerWeek + '\'' +
                ", language='" + language + '\'' +
                ", passCondition='" + passCondition + '\'' +
                ", score_average=" + score_average +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", questionReplyList=" + questionReplyList +
                ", commentList=" + commentList +
                ", weekTaskList=" + weekTaskList +
                '}';
    }
}
