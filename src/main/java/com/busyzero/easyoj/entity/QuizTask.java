package com.busyzero.easyoj.entity;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.time.Duration;
import java.time.Instant;

/**
 * 测试任务
 * @author 11456
 */
@Alias("quizTask")
public class QuizTask implements Serializable {
    private static final long serialVersionUID = 78878676127816786L;

    /**测试编号*/
    private Long quizId;

    /**测试编码:自动生成,如果不写默认是测试编号*/
    private String quizCode;

    /**测试标题*/
    private String quizTitle;

    /**课程编号*/
    private Integer courseId;

    /** 教师账户编号*/
    private Integer teacherId;

    /**测试类型:1.单元测试  2.阶段性测试  3.综合测试  4.问卷测试：非课程知识点  */
    private Short quizType;

    /**单元号*/
    private Short unitNumber;

    /**阶段号，一般来说,大于等于该阶段的题都符合*/
    private Short stageNumber;

    /**问卷编号*/
    private String questionnaireCode;

    /** 是否自动组卷：默认false*/
    private Boolean autoFit;

    /**开始时间*/
    private Instant timeStart;

    /**截至时间*/
    private Instant timeEnd;

    /**考试时长*/
    private Duration duration;

    /**测试状态:1.审核中  2.正常  3. 还没有开始  4.废弃  5.冻结  6.过期 */
    private Short quizState;

    /**满分成绩：默认100*/
    private Short fullScore;

    /**是否有单选:默认false*/
    private boolean single;

    /**单选题分值权重:默认5*/
    private Short singleWeight;

    /**单选题数目:默认20*/
    private Short singleNumber;

    /**单选题中简单题型权重：5*/
    private Short singleEasyWeight;

    /**单选题中中等题型权重：3*/
    private Short singleMiddleWeight;

    /**单选题中困难题型权重：2*/
    private Short singleHarWeight;

    /**是否有多选题*/
    private Boolean multiple;

    /**多选题权重*/
    private Short multipleWeight;

    /**多选题题目数量*/
    private Short multipleNumber;

    /**多选简单题型数量*/
    private Short multipleEasyWeight;

    /**多选中等题型权重*/
    private Short multipleMiddleWeight;

    /**多选困难提醒权重*/
    private Short multipleHardWeight;

    /**是否有填空题*/
    private Boolean complete;

    /**填空题权重*/
    private Short completeWeight;

    /**填空题数量*/
    private Short completeNumber;

    /**填空题简单题型权重*/
    private Short completeEasyWeight;

    /**填空题中等题型权重*/
    private Short completeMiddleWeight;

    /**填空题困难题型权重*/
    private Short completeHardWeight;

    /**是否有简述题*/
    private Boolean resume;

    /**简述题分值权重*/
    private Short resumeWeight;

    /**简述题数量*/
    private Short resumeNumber;

    /**简述简单提醒权重*/
    private Short resumeEasyWeight;

    /**简述中等题型权重*/
    private Short resumeMiddleWeight;

    /**简述苦难题型权重*/
    private Short resumeHardWeight;

    /**是否有综合题*/
    private Boolean synthesis;

    /**综合体分值权重*/
    private Short synthesisWeight;

    /**综合题数量*/
    private Short synthesisNumber;

    /**综合题目简单题型权重*/
    private Short synthesisEasyWeight;

    /**综合题中等题型权重*/
    private Short synthesisMiddleWeight;

    /**综合题困难题型权重*/
    private Short synthesisHardWeight;

    /**是否有附加题*/
    private Boolean extra;

    /**附加题分值*/
    private Short extraScore;

    /**额外考题项编号*/
    private Long  extraItemId;

    /**知识点:多个，用逗号进行分割*/
    private String points;

    /**创建时间*/
    private Instant gmtCreate;

    /**最后修改时间*/
    private Instant gmtModified;

    public Long getQuizId() {
        return quizId;
    }

    public void setQuizId(Long quizId) {
        this.quizId = quizId;
    }

    public String getQuizCode() {
        return quizCode;
    }

    public void setQuizCode(String quizCode) {
        this.quizCode = quizCode;
    }

    public String getQuizTitle() {
        return quizTitle;
    }

    public void setQuizTitle(String quizTitle) {
        this.quizTitle = quizTitle;
    }

    public Short getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(Short unitNumber) {
        this.unitNumber = unitNumber;
    }

    public Short getStageNumber() {
        return stageNumber;
    }

    public void setStageNumber(Short stageNumber) {
        this.stageNumber = stageNumber;
    }

    public String getQuestionnaireCode() {
        return questionnaireCode;
    }

    public void setQuestionnaireCode(String questionnaireCode) {
        this.questionnaireCode = questionnaireCode;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Short getQuizType() {
        return quizType;
    }

    public void setQuizType(Short quizType) {
        this.quizType = quizType;
    }

    public Boolean getAutoFit() {
        return autoFit;
    }

    public void setAutoFit(Boolean autoFit) {
        this.autoFit = autoFit;
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

    public Short getQuizState() {
        return quizState;
    }

    public void setQuizState(Short quizState) {
        this.quizState = quizState;
    }

    public Short getFullScore() {
        return fullScore;
    }

    public void setFullScore(Short fullScore) {
        this.fullScore = fullScore;
    }

    public boolean isSingle() {
        return single;
    }

    public void setSingle(boolean single) {
        this.single = single;
    }

    public Short getSingleWeight() {
        return singleWeight;
    }

    public void setSingleWeight(Short singleWeight) {
        this.singleWeight = singleWeight;
    }

    public Short getSingleNumber() {
        return singleNumber;
    }

    public void setSingleNumber(Short singleNumber) {
        this.singleNumber = singleNumber;
    }

    public Short getSingleEasyWeight() {
        return singleEasyWeight;
    }

    public void setSingleEasyWeight(Short singleEasyWeight) {
        this.singleEasyWeight = singleEasyWeight;
    }

    public Short getSingleMiddleWeight() {
        return singleMiddleWeight;
    }

    public void setSingleMiddleWeight(Short singleMiddleWeight) {
        this.singleMiddleWeight = singleMiddleWeight;
    }

    public Short getSingleHarWeight() {
        return singleHarWeight;
    }

    public void setSingleHarWeight(Short singleHarWeight) {
        this.singleHarWeight = singleHarWeight;
    }

    public Boolean getMultiple() {
        return multiple;
    }

    public void setMultiple(Boolean multiple) {
        this.multiple = multiple;
    }

    public Short getMultipleWeight() {
        return multipleWeight;
    }

    public void setMultipleWeight(Short multipleWeight) {
        this.multipleWeight = multipleWeight;
    }

    public Short getMultipleNumber() {
        return multipleNumber;
    }

    public void setMultipleNumber(Short multipleNumber) {
        this.multipleNumber = multipleNumber;
    }

    public Short getMultipleEasyWeight() {
        return multipleEasyWeight;
    }

    public void setMultipleEasyWeight(Short multipleEasyWeight) {
        this.multipleEasyWeight = multipleEasyWeight;
    }

    public Short getMultipleMiddleWeight() {
        return multipleMiddleWeight;
    }

    public void setMultipleMiddleWeight(Short multipleMiddleWeight) {
        this.multipleMiddleWeight = multipleMiddleWeight;
    }

    public Short getMultipleHardWeight() {
        return multipleHardWeight;
    }

    public void setMultipleHardWeight(Short multipleHardWeight) {
        this.multipleHardWeight = multipleHardWeight;
    }

    public Boolean getComplete() {
        return complete;
    }

    public void setComplete(Boolean complete) {
        this.complete = complete;
    }

    public Short getCompleteWeight() {
        return completeWeight;
    }

    public void setCompleteWeight(Short completeWeight) {
        this.completeWeight = completeWeight;
    }

    public Short getCompleteNumber() {
        return completeNumber;
    }

    public void setCompleteNumber(Short completeNumber) {
        this.completeNumber = completeNumber;
    }

    public Short getCompleteEasyWeight() {
        return completeEasyWeight;
    }

    public void setCompleteEasyWeight(Short completeEasyWeight) {
        this.completeEasyWeight = completeEasyWeight;
    }

    public Short getCompleteMiddleWeight() {
        return completeMiddleWeight;
    }

    public void setCompleteMiddleWeight(Short completeMiddleWeight) {
        this.completeMiddleWeight = completeMiddleWeight;
    }

    public Short getCompleteHardWeight() {
        return completeHardWeight;
    }

    public void setCompleteHardWeight(Short completeHardWeight) {
        this.completeHardWeight = completeHardWeight;
    }

    public Boolean getResume() {
        return resume;
    }

    public void setResume(Boolean resume) {
        this.resume = resume;
    }

    public Short getResumeWeight() {
        return resumeWeight;
    }

    public void setResumeWeight(Short resumeWeight) {
        this.resumeWeight = resumeWeight;
    }

    public Short getResumeNumber() {
        return resumeNumber;
    }

    public void setResumeNumber(Short resumeNumber) {
        this.resumeNumber = resumeNumber;
    }

    public Short getResumeEasyWeight() {
        return resumeEasyWeight;
    }

    public void setResumeEasyWeight(Short resumeEasyWeight) {
        this.resumeEasyWeight = resumeEasyWeight;
    }

    public Short getResumeMiddleWeight() {
        return resumeMiddleWeight;
    }

    public void setResumeMiddleWeight(Short resumeMiddleWeight) {
        this.resumeMiddleWeight = resumeMiddleWeight;
    }

    public Short getResumeHardWeight() {
        return resumeHardWeight;
    }

    public void setResumeHardWeight(Short resumeHardWeight) {
        this.resumeHardWeight = resumeHardWeight;
    }

    public Boolean getSynthesis() {
        return synthesis;
    }

    public void setSynthesis(Boolean synthesis) {
        this.synthesis = synthesis;
    }

    public Short getSynthesisWeight() {
        return synthesisWeight;
    }

    public void setSynthesisWeight(Short synthesisWeight) {
        this.synthesisWeight = synthesisWeight;
    }

    public Short getSynthesisNumber() {
        return synthesisNumber;
    }

    public void setSynthesisNumber(Short synthesisNumber) {
        this.synthesisNumber = synthesisNumber;
    }

    public Short getSynthesisEasyWeight() {
        return synthesisEasyWeight;
    }

    public void setSynthesisEasyWeight(Short synthesisEasyWeight) {
        this.synthesisEasyWeight = synthesisEasyWeight;
    }

    public Short getSynthesisMiddleWeight() {
        return synthesisMiddleWeight;
    }

    public void setSynthesisMiddleWeight(Short synthesisMiddleWeight) {
        this.synthesisMiddleWeight = synthesisMiddleWeight;
    }

    public Short getSynthesisHardWeight() {
        return synthesisHardWeight;
    }

    public void setSynthesisHardWeight(Short synthesisHardWeight) {
        this.synthesisHardWeight = synthesisHardWeight;
    }

    public Boolean getExtra() {
        return extra;
    }

    public void setExtra(Boolean extra) {
        this.extra = extra;
    }

    public Short getExtraScore() {
        return extraScore;
    }

    public void setExtraScore(Short extraScore) {
        this.extraScore = extraScore;
    }

    public Long getExtraItemId() {
        return extraItemId;
    }

    public void setExtraItemId(Long extraItemId) {
        this.extraItemId = extraItemId;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
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
        return "QuizTask{" +
                "quizId=" + quizId +
                ", quizCode='" + quizCode + '\'' +
                ", quizTitle='" + quizTitle + '\'' +
                ", courseId=" + courseId +
                ", teacherId=" + teacherId +
                ", quizType=" + quizType +
                ", unitNumber=" + unitNumber +
                ", stageNumber=" + stageNumber +
                ", questionnaireCode='" + questionnaireCode + '\'' +
                ", autoFit=" + autoFit +
                ", timeStart=" + timeStart +
                ", timeEnd=" + timeEnd +
                ", duration=" + duration +
                ", quizState=" + quizState +
                ", fullScore=" + fullScore +
                ", single=" + single +
                ", singleWeight=" + singleWeight +
                ", singleNumber=" + singleNumber +
                ", singleEasyWeight=" + singleEasyWeight +
                ", singleMiddleWeight=" + singleMiddleWeight +
                ", singleHarWeight=" + singleHarWeight +
                ", multiple=" + multiple +
                ", multipleWeight=" + multipleWeight +
                ", multipleNumber=" + multipleNumber +
                ", multipleEasyWeight=" + multipleEasyWeight +
                ", multipleMiddleWeight=" + multipleMiddleWeight +
                ", multipleHardWeight=" + multipleHardWeight +
                ", complete=" + complete +
                ", completeWeight=" + completeWeight +
                ", completeNumber=" + completeNumber +
                ", completeEasyWeight=" + completeEasyWeight +
                ", completeMiddleWeight=" + completeMiddleWeight +
                ", completeHardWeight=" + completeHardWeight +
                ", resume=" + resume +
                ", resumeWeight=" + resumeWeight +
                ", resumeNumber=" + resumeNumber +
                ", resumeEasyWeight=" + resumeEasyWeight +
                ", resumeMiddleWeight=" + resumeMiddleWeight +
                ", resumeHardWeight=" + resumeHardWeight +
                ", synthesis=" + synthesis +
                ", synthesisWeight=" + synthesisWeight +
                ", synthesisNumber=" + synthesisNumber +
                ", synthesisEasyWeight=" + synthesisEasyWeight +
                ", synthesisMiddleWeight=" + synthesisMiddleWeight +
                ", synthesisHardWeight=" + synthesisHardWeight +
                ", extra=" + extra +
                ", extraScore=" + extraScore +
                ", extraItemId=" + extraItemId +
                ", points='" + points + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }
}
