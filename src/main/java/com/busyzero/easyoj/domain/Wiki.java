package com.busyzero.easyoj.domain;

import java.time.Instant;

/**
 * 课程文字资料
 * Created by 11456 on 2017/6/22.
 */
public class Wiki {
    /**wiki 编号*/
    private Integer wikiId;

    /**具体任务小节编号*/
    private Integer taskItemId;

    /**wiki内容*/
    private String content;

    /**创建时间*/
    private Instant gmtCreate;

    /**最后修改时间*/
    private Instant gmtModified;

    public Integer getWikiId() {
        return wikiId;
    }

    public void setWikiId(Integer wikiId) {
        this.wikiId = wikiId;
    }

    public Integer getTaskItemId() {
        return taskItemId;
    }

    public void setTaskItemId(Integer taskItemId) {
        this.taskItemId = taskItemId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
