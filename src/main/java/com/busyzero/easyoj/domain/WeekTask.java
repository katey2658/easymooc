package com.busyzero.easyoj.domain;

import java.time.Instant;
import java.util.List;

/**
 * 每周授课大纲信息
 * Created by 11456 on 2017/6/22.
 */
public class WeekTask {
    /**每周任务编号*/
    private Integer weekTaskId;

    /**课程编号*/
    private Integer courseId;

    /**本周内容*/
    private String content;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
}
