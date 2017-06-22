package com.busyzero.easyoj.domain;

import java.time.Instant;

/**
 * 教学内容项
 * Created by 11456 on 2017/6/22.
 */
public class TaskItem {
    /**任务项分项目编号*/
    private Integer taskItemId;

    /**任务编号*/
    private Integer taskId;

    /**标题*/
    private String title;

    /**时间长度(min)*/
    private Short timeLength;

    /**视频编号*/
    private Integer videoId;

    /**wiki内容编号*/
    private Integer wikiId;

    /**测试编号*/
    private Integer testId;

    /**点赞数*/
    private Integer like;

    /**踩数*/
    private Integer trample;

    /**创建时间*/
    private Instant gmtCreate;

    /**最后修改时间*/
    private Instant gmtModified;

    /**视频内容*/
    private Video video;

    /**wiki内容*/
    private Wiki wiki;

    /**测试内容*/
    private  Test test;

    public Integer getTaskItemId() {
        return taskItemId;
    }

    public void setTaskItemId(Integer taskItemId) {
        this.taskItemId = taskItemId;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Short getTimeLength() {
        return timeLength;
    }

    public void setTimeLength(Short timeLength) {
        this.timeLength = timeLength;
    }

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public Integer getWikiId() {
        return wikiId;
    }

    public void setWikiId(Integer wikiId) {
        this.wikiId = wikiId;
    }

    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    public Integer getLike() {
        return like;
    }

    public void setLike(Integer like) {
        this.like = like;
    }

    public Integer getTrample() {
        return trample;
    }

    public void setTrample(Integer trample) {
        this.trample = trample;
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

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public Wiki getWiki() {
        return wiki;
    }

    public void setWiki(Wiki wiki) {
        this.wiki = wiki;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }
}
