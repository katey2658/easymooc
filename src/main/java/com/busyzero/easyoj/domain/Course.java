package com.busyzero.easyoj.domain;

import org.apache.ibatis.type.Alias;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

/**
 * 课程信息表
 * Created by 11456 on 2017/6/22.
 */
@Alias("course")
public class Course {
    /**课程编号*/
    private Integer courseId;

    /**所属学科编号*/
    private Short subjectId;

    /**课程名*/
    private String courseName;

    /**课程概述*/
    private String description;

    /**课程须知*/
    private String preCondition;

    /**课程图片*/
    private String courseImage;

    /**课程提供方名字称*/
    private String providerName;

    /**课程提供方logo*/
    private String providerLogo;

    /**课程提供方ID*/
    private Integer providerId;

    /**授课老师头像*/
    private String teacherPhoto;

    /**授课老师全名*/
    private String teacherName;

    /**授课老师职称*/
    private String teacherJobTitle;

    /**授课教师签名*/
    private String teacherSignature;

    /**教学方教师编号*/
    private Integer teacherId;

    /**课程开始时间*/
    private Instant timeStart;

    /**课程结束时间*/
    private Instant timeEnd;

    /**使用学生级别*/
    private String studentLevel;

    /**每周学习时间*/
    private String timeLearn;

    /**授课语言*/
    private String languageToTeach;

    /**通过课程条件*/
    private String passCondition;

    /**有证书价格*/
    private BigDecimal priceWithCertificate;

    /**没有证书价格*/
    private BigDecimal priceWithNoCertificate;

    /**创建时间*/
    private Instant gmtCreate;

    /**最后修改时间*/
    private Instant gmtModified;

    /**提供方信息*/
    private Provider provider;

    /** 教学方信息*/
    private Teacher teacher;

    /**课程列表加回答*/
    private List<QuestionReply> questionReplyList;

    /**评论信息列表:只取4条暂时*/
    private List<Comment>commentList;

    /**授课大纲信息表：只存放一周*/
    private List<WeekTask> weekTaskList;

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Short getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Short subjectId) {
        this.subjectId = subjectId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPreCondition() {
        return preCondition;
    }

    public void setPreCondition(String preCondition) {
        this.preCondition = preCondition;
    }

    public String getCourseImage() {
        return courseImage;
    }

    public void setCourseImage(String courseImage) {
        this.courseImage = courseImage;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getProviderLogo() {
        return providerLogo;
    }

    public void setProviderLogo(String providerLogo) {
        this.providerLogo = providerLogo;
    }

    public Integer getProviderId() {
        return providerId;
    }

    public void setProviderId(Integer providerId) {
        this.providerId = providerId;
    }

    public String getTeacherPhoto() {
        return teacherPhoto;
    }

    public void setTeacherPhoto(String teacherPhoto) {
        this.teacherPhoto = teacherPhoto;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherJobTitle() {
        return teacherJobTitle;
    }

    public void setTeacherJobTitle(String teacherJobTitle) {
        this.teacherJobTitle = teacherJobTitle;
    }

    public String getTeacherSignature() {
        return teacherSignature;
    }

    public void setTeacherSignature(String teacherSignature) {
        this.teacherSignature = teacherSignature;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
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

    public String getStudentLevel() {
        return studentLevel;
    }

    public void setStudentLevel(String studentLevel) {
        this.studentLevel = studentLevel;
    }

    public String getTimeLearn() {
        return timeLearn;
    }

    public void setTimeLearn(String timeLearn) {
        this.timeLearn = timeLearn;
    }

    public String getLanguageToTeach() {
        return languageToTeach;
    }

    public void setLanguageToTeach(String languageToTeach) {
        this.languageToTeach = languageToTeach;
    }

    public String getPassCondition() {
        return passCondition;
    }

    public void setPassCondition(String passCondition) {
        this.passCondition = passCondition;
    }

    public BigDecimal getPriceWithCertificate() {
        return priceWithCertificate;
    }

    public void setPriceWithCertificate(BigDecimal priceWithCertificate) {
        this.priceWithCertificate = priceWithCertificate;
    }

    public BigDecimal getPriceWithNoCertificate() {
        return priceWithNoCertificate;
    }

    public void setPriceWithNoCertificate(BigDecimal priceWithNoCertificate) {
        this.priceWithNoCertificate = priceWithNoCertificate;
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

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
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
                ", subjectId=" + subjectId +
                ", courseName='" + courseName + '\'' +
                ", description='" + description + '\'' +
                ", preCondition='" + preCondition + '\'' +
                ", courseImage='" + courseImage + '\'' +
                ", providerName='" + providerName + '\'' +
                ", providerLogo='" + providerLogo + '\'' +
                ", providerId=" + providerId +
                ", teacherPhoto='" + teacherPhoto + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", teacherJobTitle='" + teacherJobTitle + '\'' +
                ", teacherSignature='" + teacherSignature + '\'' +
                ", teacherId=" + teacherId +
                ", timeStart=" + timeStart +
                ", timeEnd=" + timeEnd +
                ", studentLevel='" + studentLevel + '\'' +
                ", timeLearn='" + timeLearn + '\'' +
                ", languageToTeach='" + languageToTeach + '\'' +
                ", passCondition='" + passCondition + '\'' +
                ", priceWithCertificate=" + priceWithCertificate +
                ", priceWithNoCertificate=" + priceWithNoCertificate +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", provider=" + provider +
                ", teacher=" + teacher +
                ", questionReplyList=" + questionReplyList +
                ", commentList=" + commentList +
                ", weekTaskList=" + weekTaskList +
                '}';
    }
}
