package com.busyzero.easyoj.domain;

import java.time.Instant;

/**
 * 测试信息:    TODO
 * Created by 11456 on 2017/6/22.
 */
public class Test {
    /**测试编号*/
    private Integer testId;

    /**具体小节编号*/
    private Integer taskItemId;

    /**
     *
     * TODO
     */
    /**创建时间*/
    private Instant gmtCreate;

    /**最后修改时间*/
    private Instant gmtModified;

    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    public Integer getTaskItemId() {
        return taskItemId;
    }

    public void setTaskItemId(Integer taskItemId) {
        this.taskItemId = taskItemId;
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
