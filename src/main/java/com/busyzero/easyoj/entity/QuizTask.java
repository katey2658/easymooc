package com.busyzero.easyoj.entity;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.time.Duration;
import java.time.Instant;

/**
 * <Description>测试任务</Description>
 * @author katey2658
 * @date 2018/3/5
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
    private Integer quizType;

    /**单元号*/
    private Integer unitNumber;

    /**阶段号，一般来说,大于等于该阶段的题都符合*/
    private Integer stageNumber;

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
    private Integer quizState;

    /**满分成绩：默认100*/
    private Integer fullScore;

    /**是否有单选:默认false*/
    private boolean single;

    /**单选题分值权重:默认5*/
    private Integer singleWeight;

    /**单选题数目:默认20*/
    private Integer singleNumber;

    /**单选题中简单题型权重：5*/
    private Integer singleEasyWeight;

    /**单选题中中等题型权重：3*/
    private Integer singleMiddleWeight;

    /**单选题中困难题型权重：2*/
    private Integer singleHarWeight;

    /**是否有多选题*/
    private Boolean multiple;

    /**多选题权重*/
    private Integer multipleWeight;

    /**多选题题目数量*/
    private Integer multipleNumber;

    /**多选简单题型数量*/
    private Integer multipleEasyWeight;

    /**多选中等题型权重*/
    private Integer multipleMiddleWeight;

    /**多选困难提醒权重*/
    private Integer multipleHardWeight;

    /**是否有填空题*/
    private Boolean complete;

    /**填空题权重*/
    private Integer completeWeight;

    /**填空题数量*/
    private Integer completeNumber;

    /**填空题简单题型权重*/
    private Integer completeEasyWeight;

    /**填空题中等题型权重*/
    private Integer completeMiddleWeight;

    /**填空题困难题型权重*/
    private Integer completeHardWeight;

    /**是否有简述题*/
    private Boolean resume;

    /**简述题分值权重*/
    private Integer resumeWeight;

    /**简述题数量*/
    private Integer resumeNumber;

    /**简述简单提醒权重*/
    private Integer resumeEasyWeight;

    /**简述中等题型权重*/
    private Integer resumeMiddleWeight;

    /**简述苦难题型权重*/
    private Integer resumeHardWeight;

    /**是否有综合题*/
    private Boolean synthesis;

    /**综合体分值权重*/
    private Integer synthesisWeight;

    /**综合题数量*/
    private Integer synthesisNumber;

    /**综合题目简单题型权重*/
    private Integer synthesisEasyWeight;

    /**综合题中等题型权重*/
    private Integer synthesisMiddleWeight;

    /**综合题困难题型权重*/
    private Integer synthesisHardWeight;

    /**是否有附加题*/
    private Boolean extra;

    /**附加题分值*/
    private Integer extraScore;

    /**额外考题项编号*/
    private Long  extraItemId;

    /**知识点:多个，用逗号进行分割*/
    private String points;

    /** 删除标志 */
    private Integer delFlag;

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

    public Integer getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(Integer unitNumber) {
        this.unitNumber = unitNumber;
    }

    public Integer getStageNumber() {
        return stageNumber;
    }

    public void setStageNumber(Integer stageNumber) {
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

    public Integer getQuizType() {
        return quizType;
    }

    public void setQuizType(Integer quizType) {
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

    public Integer getQuizState() {
        return quizState;
    }

    public void setQuizState(Integer quizState) {
        this.quizState = quizState;
    }

    public Integer getFullScore() {
        return fullScore;
    }

    public void setFullScore(Integer fullScore) {
        this.fullScore = fullScore;
    }

    public boolean isSingle() {
        return single;
    }

    public void setSingle(boolean single) {
        this.single = single;
    }

    public Integer getSingleWeight() {
        return singleWeight;
    }

    public void setSingleWeight(Integer singleWeight) {
        this.singleWeight = singleWeight;
    }

    public Integer getSingleNumber() {
        return singleNumber;
    }

    public void setSingleNumber(Integer singleNumber) {
        this.singleNumber = singleNumber;
    }

    public Integer getSingleEasyWeight() {
        return singleEasyWeight;
    }

    public void setSingleEasyWeight(Integer singleEasyWeight) {
        this.singleEasyWeight = singleEasyWeight;
    }

    public Integer getSingleMiddleWeight() {
        return singleMiddleWeight;
    }

    public void setSingleMiddleWeight(Integer singleMiddleWeight) {
        this.singleMiddleWeight = singleMiddleWeight;
    }

    public Integer getSingleHarWeight() {
        return singleHarWeight;
    }

    public void setSingleHarWeight(Integer singleHarWeight) {
        this.singleHarWeight = singleHarWeight;
    }

    public Boolean getMultiple() {
        return multiple;
    }

    public void setMultiple(Boolean multiple) {
        this.multiple = multiple;
    }

    public Integer getMultipleWeight() {
        return multipleWeight;
    }

    public void setMultipleWeight(Integer multipleWeight) {
        this.multipleWeight = multipleWeight;
    }

    public Integer getMultipleNumber() {
        return multipleNumber;
    }

    public void setMultipleNumber(Integer multipleNumber) {
        this.multipleNumber = multipleNumber;
    }

    public Integer getMultipleEasyWeight() {
        return multipleEasyWeight;
    }

    public void setMultipleEasyWeight(Integer multipleEasyWeight) {
        this.multipleEasyWeight = multipleEasyWeight;
    }

    public Integer getMultipleMiddleWeight() {
        return multipleMiddleWeight;
    }

    public void setMultipleMiddleWeight(Integer multipleMiddleWeight) {
        this.multipleMiddleWeight = multipleMiddleWeight;
    }

    public Integer getMultipleHardWeight() {
        return multipleHardWeight;
    }

    public void setMultipleHardWeight(Integer multipleHardWeight) {
        this.multipleHardWeight = multipleHardWeight;
    }

    public Boolean getComplete() {
        return complete;
    }

    public void setComplete(Boolean complete) {
        this.complete = complete;
    }

    public Integer getCompleteWeight() {
        return completeWeight;
    }

    public void setCompleteWeight(Integer completeWeight) {
        this.completeWeight = completeWeight;
    }

    public Integer getCompleteNumber() {
        return completeNumber;
    }

    public void setCompleteNumber(Integer completeNumber) {
        this.completeNumber = completeNumber;
    }

    public Integer getCompleteEasyWeight() {
        return completeEasyWeight;
    }

    public void setCompleteEasyWeight(Integer completeEasyWeight) {
        this.completeEasyWeight = completeEasyWeight;
    }

    public Integer getCompleteMiddleWeight() {
        return completeMiddleWeight;
    }

    public void setCompleteMiddleWeight(Integer completeMiddleWeight) {
        this.completeMiddleWeight = completeMiddleWeight;
    }

    public Integer getCompleteHardWeight() {
        return completeHardWeight;
    }

    public void setCompleteHardWeight(Integer completeHardWeight) {
        this.completeHardWeight = completeHardWeight;
    }

    public Boolean getResume() {
        return resume;
    }

    public void setResume(Boolean resume) {
        this.resume = resume;
    }

    public Integer getResumeWeight() {
        return resumeWeight;
    }

    public void setResumeWeight(Integer resumeWeight) {
        this.resumeWeight = resumeWeight;
    }

    public Integer getResumeNumber() {
        return resumeNumber;
    }

    public void setResumeNumber(Integer resumeNumber) {
        this.resumeNumber = resumeNumber;
    }

    public Integer getResumeEasyWeight() {
        return resumeEasyWeight;
    }

    public void setResumeEasyWeight(Integer resumeEasyWeight) {
        this.resumeEasyWeight = resumeEasyWeight;
    }

    public Integer getResumeMiddleWeight() {
        return resumeMiddleWeight;
    }

    public void setResumeMiddleWeight(Integer resumeMiddleWeight) {
        this.resumeMiddleWeight = resumeMiddleWeight;
    }

    public Integer getResumeHardWeight() {
        return resumeHardWeight;
    }

    public void setResumeHardWeight(Integer resumeHardWeight) {
        this.resumeHardWeight = resumeHardWeight;
    }

    public Boolean getSynthesis() {
        return synthesis;
    }

    public void setSynthesis(Boolean synthesis) {
        this.synthesis = synthesis;
    }

    public Integer getSynthesisWeight() {
        return synthesisWeight;
    }

    public void setSynthesisWeight(Integer synthesisWeight) {
        this.synthesisWeight = synthesisWeight;
    }

    public Integer getSynthesisNumber() {
        return synthesisNumber;
    }

    public void setSynthesisNumber(Integer synthesisNumber) {
        this.synthesisNumber = synthesisNumber;
    }

    public Integer getSynthesisEasyWeight() {
        return synthesisEasyWeight;
    }

    public void setSynthesisEasyWeight(Integer synthesisEasyWeight) {
        this.synthesisEasyWeight = synthesisEasyWeight;
    }

    public Integer getSynthesisMiddleWeight() {
        return synthesisMiddleWeight;
    }

    public void setSynthesisMiddleWeight(Integer synthesisMiddleWeight) {
        this.synthesisMiddleWeight = synthesisMiddleWeight;
    }

    public Integer getSynthesisHardWeight() {
        return synthesisHardWeight;
    }

    public void setSynthesisHardWeight(Integer synthesisHardWeight) {
        this.synthesisHardWeight = synthesisHardWeight;
    }

    public Boolean getExtra() {
        return extra;
    }

    public void setExtra(Boolean extra) {
        this.extra = extra;
    }

    public Integer getExtraScore() {
        return extraScore;
    }

    public void setExtraScore(Integer extraScore) {
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

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
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
                ", delFlag=" + delFlag +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }
}
