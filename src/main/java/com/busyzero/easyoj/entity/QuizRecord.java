package com.busyzero.easyoj.entity;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.time.Duration;
import java.time.Instant;

/**
 * <Description>测试相关参数的记录</Description>
 * @author katey2658
 */
@Alias("quizRecord")
public class QuizRecord implements Serializable {
    private static final long serialVersionUID = 78878676127816788L;

    /**考卷编号*/
    private Long recordId;

    /**考试编号*/
    private Long quizId;

    /**账户编号*/
    private Integer accountId;

    /**如果是同一份试卷，一样的题目*/
    private Long fromRecordId;

    /**单选总成绩*/
    private Integer singleTotalScore;

    /**单选正确率:千分比*/
    private Integer singleAccuracy;

    /**多选总成绩*/
    private Integer multiTotalScore;

    /**多选正确率:千分比*/
    private Integer multiAccuracy;

    /**填空总成绩*/
    private Integer completeScore;

    /**多选正确率:千分比*/
    private Integer completeAccuracy;

    /**简述总成绩*/
    private Integer resumeScore;

    /**简述正确率:千分比*/
    private Integer resumeAccuracy;

    /**综合总成绩*/
    private Integer synthesisScore;

    /**综合正确率:千分比*/
    private Integer synthesisAccuracy;

    /**附加总成绩*/
    private Integer extraScore;

    /**附加正确率:千分比*/
    private Integer extraAccuracy;

    /**试卷总分*/
    private Integer fullScore;

    /**试卷得分总分*/
    private Integer totalScore;

    /**测试记录状态：1.考试中  2.正常结束  3.超时  4.异常退出 5.还没有开始*/
    private Integer recordState;

    /**开始时间*/
    private Instant timeStart;

    /**结束时间*/
    private Instant timeEnd;

    /**考试用时*/
    private Duration duration;

    /** 删除标志 */
    private Integer delFlag;

    /**创建时间*/
    private Instant gmtCreate;

    /**最后修改时间*/
    private Instant gmtModified;

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public Long getQuizId() {
        return quizId;
    }

    public void setQuizId(Long quizId) {
        this.quizId = quizId;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Long getFromRecordId() {
        return fromRecordId;
    }

    public void setFromRecordId(Long fromRecordId) {
        this.fromRecordId = fromRecordId;
    }

    public Integer getSingleTotalScore() {
        return singleTotalScore;
    }

    public void setSingleTotalScore(Integer singleTotalScore) {
        this.singleTotalScore = singleTotalScore;
    }

    public Integer getSingleAccuracy() {
        return singleAccuracy;
    }

    public void setSingleAccuracy(Integer singleAccuracy) {
        this.singleAccuracy = singleAccuracy;
    }

    public Integer getMultiTotalScore() {
        return multiTotalScore;
    }

    public void setMultiTotalScore(Integer multiTotalScore) {
        this.multiTotalScore = multiTotalScore;
    }

    public Integer getMultiAccuracy() {
        return multiAccuracy;
    }

    public void setMultiAccuracy(Integer multiAccuracy) {
        this.multiAccuracy = multiAccuracy;
    }

    public Integer getCompleteScore() {
        return completeScore;
    }

    public void setCompleteScore(Integer completeScore) {
        this.completeScore = completeScore;
    }

    public Integer getCompleteAccuracy() {
        return completeAccuracy;
    }

    public void setCompleteAccuracy(Integer completeAccuracy) {
        this.completeAccuracy = completeAccuracy;
    }

    public Integer getResumeScore() {
        return resumeScore;
    }

    public void setResumeScore(Integer resumeScore) {
        this.resumeScore = resumeScore;
    }

    public Integer getResumeAccuracy() {
        return resumeAccuracy;
    }

    public void setResumeAccuracy(Integer resumeAccuracy) {
        this.resumeAccuracy = resumeAccuracy;
    }

    public Integer getSynthesisScore() {
        return synthesisScore;
    }

    public void setSynthesisScore(Integer synthesisScore) {
        this.synthesisScore = synthesisScore;
    }

    public Integer getSynthesisAccuracy() {
        return synthesisAccuracy;
    }

    public void setSynthesisAccuracy(Integer synthesisAccuracy) {
        this.synthesisAccuracy = synthesisAccuracy;
    }

    public Integer getExtraScore() {
        return extraScore;
    }

    public void setExtraScore(Integer extraScore) {
        this.extraScore = extraScore;
    }

    public Integer getExtraAccuracy() {
        return extraAccuracy;
    }

    public void setExtraAccuracy(Integer extraAccuracy) {
        this.extraAccuracy = extraAccuracy;
    }

    public Integer getFullScore() {
        return fullScore;
    }

    public void setFullScore(Integer fullScore) {
        this.fullScore = fullScore;
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }

    public Integer getRecordState() {
        return recordState;
    }

    public void setRecordState(Integer recordState) {
        this.recordState = recordState;
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

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
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
        return "QuizRecord{" +
                "recordId=" + recordId +
                ", quizId=" + quizId +
                ", accountId=" + accountId +
                ", fromRecordId=" + fromRecordId +
                ", singleTotalScore=" + singleTotalScore +
                ", singleAccuracy=" + singleAccuracy +
                ", multiTotalScore=" + multiTotalScore +
                ", multiAccuracy=" + multiAccuracy +
                ", completeScore=" + completeScore +
                ", completeAccuracy=" + completeAccuracy +
                ", resumeScore=" + resumeScore +
                ", resumeAccuracy=" + resumeAccuracy +
                ", synthesisScore=" + synthesisScore +
                ", synthesisAccuracy=" + synthesisAccuracy +
                ", extraScore=" + extraScore +
                ", extraAccuracy=" + extraAccuracy +
                ", fullScore=" + fullScore +
                ", totalScore=" + totalScore +
                ", recordState=" + recordState +
                ", timeStart=" + timeStart +
                ", timeEnd=" + timeEnd +
                ", duration=" + duration +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }
}
