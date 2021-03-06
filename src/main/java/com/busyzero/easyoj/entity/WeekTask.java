package com.busyzero.easyoj.entity;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

/**
 * <Description>每周授课大纲信息</Description>
 * @author katey2658
 * @date 2017/6/22.
 */
@Alias("weekTask")
public class WeekTask implements Serializable {
    private static final long serialVersionUID = -789067543676367887L;
    /**每周任务编号*/
    private Integer weekTaskId;

    /**课程编号*/
    private Integer courseId;

    /**本周内容*/
    private String contentTitle;

    /**开始时间*/
    private Instant timeStart;

    /**结束时间*/
    private Instant timeEnd;

    /**介绍*/
    private String introduction;

    /**创建时间*/
    private Instant gmtCreate;

    /**最后修改时间*/
    private Instant gmtModified;

    /**每周任务列表*/
    private List<Task> taskList;

    public Integer getWeekTaskId() {
        return weekTaskId;
    }

    public void setWeekTaskId(Integer weekTaskId) {
        this.weekTaskId = weekTaskId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getContentTitle() {
        return contentTitle;
    }

    public void setContentTitle(String contentTitle) {
        this.contentTitle = contentTitle;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
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

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
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
        return "WeekTask{" +
                "weekTaskId=" + weekTaskId +
                ", courseId=" + courseId +
                ", contentTitle='" + contentTitle + '\'' +
                ", timeStart=" + timeStart +
                ", timeEnd=" + timeEnd +
                ", introduction='" + introduction + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", taskList=" + taskList +
                '}';
    }
}
