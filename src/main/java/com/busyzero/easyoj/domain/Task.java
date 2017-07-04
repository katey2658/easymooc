package com.busyzero.easyoj.domain;


import org.apache.ibatis.type.Alias;

import java.time.Instant;
import java.util.List;

/**
 * 每周详细任务列表
 * Created by 11456 on 2017/6/22.
 */
@Alias("task")
public class Task {
    /**每周任务列表编号*/
    private Integer taskId;

    /**所属每周任务*/
    private Integer weekTaskId;

    /**在一周任务中的第几章节*/
    private Short orderInWeek;

    /**任务标题*/
    private String title;

    /**创建时间*/
    private Instant gmtCreate;

    /**最后修改时间*/
    private Instant gmtModified;

    /**章中小节*/
    private List<TaskItem> taskItemList;

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public Integer getWeekTaskId() {
        return weekTaskId;
    }

    public void setWeekTaskId(Integer weekTaskId) {
        this.weekTaskId = weekTaskId;
    }

    public String getTitle() {
        return title;
    }

    public Short getOrderInWeek() {
        return orderInWeek;
    }

    public void setOrderInWeek(Short orderInWeek) {
        this.orderInWeek = orderInWeek;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public List<TaskItem> getTaskItemList() {
        return taskItemList;
    }

    public void setTaskItemList(List<TaskItem> taskItemList) {
        this.taskItemList = taskItemList;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", weekTaskId=" + weekTaskId +
                ", orderInWeek=" + orderInWeek +
                ", title='" + title + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", taskItemList=" + taskItemList +
                '}';
    }
}
