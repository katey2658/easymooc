package com.busyzero.easyoj.entity;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

/**
 * 课程信息表
 * Created by 11456 on 2017/6/22.
 */
@Alias("courseInfo")
public class CourseInfo implements Serializable {
    private static final long serialVersionUID = 78878676127816781L;

    /**课程编号*/
    private Integer courseId;

    /**所属学科编号*/
    private Short subjectId;

    /**课程名*/
    private String courseName;

    /**是否公开*/
    private Boolean overt;

    /**当不公开的时候的邀请码*/
    private String inviteCode;

    /**课程概述*/
    private String description;

    /**课程须知*/
    private String preCondition;

    /**课程图片*/
    private String courseImage;

    /**授课老师头像*/
    private String teacherPhoto;

    /**授课老师全名*/
    private String teacherName;

    /**教学方教师编号*/
    private Integer teacherId;

    /**授课老师职称*/
    private String teacherJobTitle;

    /**授课教师签名*/
    private String teacherSignature;

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

    /**学生限制*/
    private String maxNumber;

    /**课程状态:1.审核中  2.正常  3. 还没有开始  4.满员  5.冻结  6.过期 */
    private Short courseState;

    /**有证书价格*/
    private BigDecimal priceWithCertificate;

    /**没有证书价格*/
    private BigDecimal priceWithNoCertificate;

    /**创建时间*/
    private Instant gmtCreate;

    /**最后修改时间*/
    private Instant gmtModified;

    /** 教学方信息*/
    private AccountInfo teacher;

    /**课程列表加回答*/
    private List<CourseQuestion> courseQuestionList;

    /**评论信息列表:只取4条暂时*/
    private List<CourseComment> courseCommentList;

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

    public Boolean getOvert() {
        return overt;
    }

    public void setOvert(Boolean overt) {
        this.overt = overt;
    }

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
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

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
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

    public String getMaxNumber() {
        return maxNumber;
    }

    public void setMaxNumber(String maxNumber) {
        this.maxNumber = maxNumber;
    }

    public Short getCourseState() {
        return courseState;
    }

    public void setCourseState(Short courseState) {
        this.courseState = courseState;
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

    public AccountInfo getTeacher() {
        return teacher;
    }

    public void setTeacher(AccountInfo teacher) {
        this.teacher = teacher;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public List<CourseQuestion> getCourseQuestionList() {
        return courseQuestionList;
    }

    public void setCourseQuestionList(List<CourseQuestion> courseQuestionList) {
        this.courseQuestionList = courseQuestionList;
    }

    public List<CourseComment> getCourseCommentList() {
        return courseCommentList;
    }

    public void setCourseCommentList(List<CourseComment> courseCommentList) {
        this.courseCommentList = courseCommentList;
    }

    public List<WeekTask> getWeekTaskList() {
        return weekTaskList;
    }

    public void setWeekTaskList(List<WeekTask> weekTaskList) {
        this.weekTaskList = weekTaskList;
    }

    @Override
    public String toString() {
        return "CourseInfo{" +
                "courseId=" + courseId +
                ", subjectId=" + subjectId +
                ", courseName='" + courseName + '\'' +
                ", overt=" + overt +
                ", inviteCode='" + inviteCode + '\'' +
                ", description='" + description + '\'' +
                ", preCondition='" + preCondition + '\'' +
                ", courseImage='" + courseImage + '\'' +
                ", teacherPhoto='" + teacherPhoto + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", teacherId=" + teacherId +
                ", teacherJobTitle='" + teacherJobTitle + '\'' +
                ", teacherSignature='" + teacherSignature + '\'' +
                ", timeStart=" + timeStart +
                ", timeEnd=" + timeEnd +
                ", studentLevel='" + studentLevel + '\'' +
                ", timeLearn='" + timeLearn + '\'' +
                ", languageToTeach='" + languageToTeach + '\'' +
                ", passCondition='" + passCondition + '\'' +
                ", maxNumber='" + maxNumber + '\'' +
                ", courseState=" + courseState +
                ", priceWithCertificate=" + priceWithCertificate +
                ", priceWithNoCertificate=" + priceWithNoCertificate +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", teacher=" + teacher +
                ", courseQuestionList=" + courseQuestionList +
                ", courseCommentList=" + courseCommentList +
                ", weekTaskList=" + weekTaskList +
                '}';
    }
}
