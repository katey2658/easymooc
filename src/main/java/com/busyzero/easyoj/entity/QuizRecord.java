package com.busyzero.easyoj.entity;

import java.io.Serializable;
import java.time.Duration;
import java.time.Instant;

/**
 * 测试相关参数的记录
 * @author 11456
 */
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
    private Short singleTotalSocre;

    /**单选正确率:千分比*/
    private Integer singleAccuracy;

    /**多选总成绩*/
    private Short multiTotalSocre;

    /**多选正确率:千分比*/
    private Integer multiAccuracy;

    /**填空总成绩*/
    private Short completeScore;

    /**多选正确率:千分比*/
    private Integer completeAccuracy;

    /**简述总成绩*/
    private Short resumeScore;

    /**简述正确率:千分比*/
    private Integer resumeAccuracy;

    /**综合总成绩*/
    private Short synthesisScore;

    /**综合正确率:千分比*/
    private Integer synthesisAccuracy;

    /**附加总成绩*/
    private Short extraScore;

    /**附加正确率:千分比*/
    private Integer extraAccuracy;

    /**试卷总分*/
    private Short fullScore;

    /**试卷得分总分*/
    private Short totalScore;

    /**测试记录状态：1.考试中  2.正常结束  3.超时  4.异常退出*/
    private Short recordState;

    /**开始时间*/
    private Instant timeStart;

    /**结束时间*/
    private Instant timeEnd;

    /**考试用时*/
    private Duration duration;

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

    public Short getSingleTotalSocre() {
        return singleTotalSocre;
    }

    public void setSingleTotalSocre(Short singleTotalSocre) {
        this.singleTotalSocre = singleTotalSocre;
    }

    public Integer getSingleAccuracy() {
        return singleAccuracy;
    }

    public void setSingleAccuracy(Integer singleAccuracy) {
        this.singleAccuracy = singleAccuracy;
    }

    public Short getMultiTotalSocre() {
        return multiTotalSocre;
    }

    public void setMultiTotalSocre(Short multiTotalSocre) {
        this.multiTotalSocre = multiTotalSocre;
    }

    public Integer getMultiAccuracy() {
        return multiAccuracy;
    }

    public void setMultiAccuracy(Integer multiAccuracy) {
        this.multiAccuracy = multiAccuracy;
    }

    public Short getCompleteScore() {
        return completeScore;
    }

    public void setCompleteScore(Short completeScore) {
        this.completeScore = completeScore;
    }

    public Integer getCompleteAccuracy() {
        return completeAccuracy;
    }

    public void setCompleteAccuracy(Integer completeAccuracy) {
        this.completeAccuracy = completeAccuracy;
    }

    public Short getResumeScore() {
        return resumeScore;
    }

    public void setResumeScore(Short resumeScore) {
        this.resumeScore = resumeScore;
    }

    public Integer getResumeAccuracy() {
        return resumeAccuracy;
    }

    public void setResumeAccuracy(Integer resumeAccuracy) {
        this.resumeAccuracy = resumeAccuracy;
    }

    public Short getSynthesisScore() {
        return synthesisScore;
    }

    public void setSynthesisScore(Short synthesisScore) {
        this.synthesisScore = synthesisScore;
    }

    public Integer getSynthesisAccuracy() {
        return synthesisAccuracy;
    }

    public void setSynthesisAccuracy(Integer synthesisAccuracy) {
        this.synthesisAccuracy = synthesisAccuracy;
    }

    public Short getExtraScore() {
        return extraScore;
    }

    public void setExtraScore(Short extraScore) {
        this.extraScore = extraScore;
    }

    public Integer getExtraAccuracy() {
        return extraAccuracy;
    }

    public void setExtraAccuracy(Integer extraAccuracy) {
        this.extraAccuracy = extraAccuracy;
    }

    public Short getFullScore() {
        return fullScore;
    }

    public void setFullScore(Short fullScore) {
        this.fullScore = fullScore;
    }

    public Short getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Short totalScore) {
        this.totalScore = totalScore;
    }

    public Short getRecordState() {
        return recordState;
    }

    public void setRecordState(Short recordState) {
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
                ", singleTotalSocre=" + singleTotalSocre +
                ", singleAccuracy=" + singleAccuracy +
                ", multiTotalSocre=" + multiTotalSocre +
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
