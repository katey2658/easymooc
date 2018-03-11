package com.busyzero.easyoj.entity;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.time.Instant;

/**
 * 教学内容项
 * @author katey2658
 * @date 2017/6/22.
 */
@Alias("taskItem")
public class TaskItem implements Serializable{
    private static final long serialVersionUID = -7817823816786278L;
    /**任务项分项目编号*/
    private Integer taskItemId;

    /**任务编号*/
    private Integer taskId;

    /**标题*/
    private String title;

    /**时间长度(min)*/
    private Short timeLength;

    /**视频编号*/
    private Integer videoInfoId;

    /**wiki内容编号*/
    private Integer wikiId;

    /**视频地址*/
    private String videoUrl;

//    /**测试编号*/
//    private Integer testId;
//
//    /**点赞数*/
//    private Integer like;
//
//    /**踩数*/
//    private Integer trample;

    /**创建时间*/
    private Instant gmtCreate;

    /**最后修改时间*/
    private Instant gmtModified;

    /**视频内容*/
    private VideoInfo videoInfo;

    /**wiki内容*/
    private Wiki wiki;

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

    public Integer getVideoInfoId() {
        return videoInfoId;
    }

    public void setVideoInfoId(Integer videoInfoId) {
        this.videoInfoId = videoInfoId;
    }

    public Integer getWikiId() {
        return wikiId;
    }

    public void setWikiId(Integer wikiId) {
        this.wikiId = wikiId;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
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

    public VideoInfo getVideoInfo() {
        return videoInfo;
    }

    public void setVideoInfo(VideoInfo videoInfo) {
        this.videoInfo = videoInfo;
    }

    public Wiki getWiki() {
        return wiki;
    }

    public void setWiki(Wiki wiki) {
        this.wiki = wiki;
    }

    @Override
    public String toString() {
        return "TaskItem{" +
                "taskItemId=" + taskItemId +
                ", taskId=" + taskId +
                ", title='" + title + '\'' +
                ", timeLength=" + timeLength +
                ", videoInfoId=" + videoInfoId +
                ", wikiId=" + wikiId +
                ", videoUrl='" + videoUrl + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", videoInfo=" + videoInfo +
                ", wiki=" + wiki +
                '}';
    }
}
