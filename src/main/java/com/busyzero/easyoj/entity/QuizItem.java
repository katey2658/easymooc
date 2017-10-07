package com.busyzero.easyoj.entity;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.time.Instant;

/**
 * 相应的题目
 * @author 11456
 */
@Alias("quizItem")
public class QuizItem implements Serializable {
    private static final long serialVersionUID = 78878676127816787L;

    /**题目编号*/
    private Long itemId;

    /**课程编号:关于这个，之后可以做到班级关联，课程是课程，班级是班级*/
    private Integer courseId;

    /**单元号*/
    private Short unitNumber;

    /**阶段号*/
    private Short stageNumber;

    /**问卷编号*/
    private String questionnaireCode;

    /**题目类型:1.单选  2.多选  3.填空题  4.简答题  5.综合题  6.附加题*/
    private Short itemType;

    /**状态：1.审核中  2.正常  3.废弃  4.冻结，被排除  默认正常*/
    private Short itemState;

    /**题目内容*/
    private String itemContent;

    /**附件：一般就是图片，暂时没有其它的打算*/
    private String attachment;

    /**
     * 进行说明,关于这个其实是有很多的方案是可以做的，包括可以不写是否正确，直接
     * 用一个数字来表示选择的是哪几项，
     * 也可以分离出去做成单独的一张表
     * 但是这里为了前期逻辑清晰，处理起来简单就先这样做
     * 之后如果要做更行迭代的话会采用更佳的方案
     */

    /**选项A*/
    private String optionA;

    /**A选项是否正确*/
    private Boolean aRight;

    /**选项B*/
    private String optionB;

    /**B选项是否正确*/
    private Boolean bRight;

    /**选项C*/
    private String optionC;

    /**C选项是否正确*/
    private Boolean cRight;

    /**选项D*/
    private String optionD;

    /**D选项是否正确*/
    private Boolean dRight;

    /**选择E*/
    private String optionE;

    /**E选择是否正确*/
    private Boolean eRight;

    /**填空数<=3：当为填空题的时候进行需要填写的内容*/
    private Short completeNumber;

    /**填空A答案*/
    private String aComplete;

    /**填空B答案*/
    private String bComplete;

    /**填空C答案*/
    private String cComplete;

    /**简述题答案，这个要做文本相似度分析，再说吧*/
    private String resumeRight;

    /**综合题目答案，可能会有图片附件*/
    private String synthesisRight;

    /**综合题附件：一般为图片*/
    private String synthesisRightAttachment;

    /**考点*/
    private String points;

    /** 以下为一些参考系数,用来进行选择,会不断进行变化*/

    /**难度系数初始值都相同：*/
    private Short degreeOfDifficulty;

    /**频率系数:频率越大，同等条件下，越不容易被选到*/
    private Short degreeOfFrequency;

    /**题目权重,也就是重要值，这个一般是由录入者来进行确定，但也会出现相应的变化*/
    private Short itemWeight;

    /**创建时间*/
    private Instant gmtCreate;

    /**最后修改时间*/
    private Instant gmtModified;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
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

    public Short getItemType() {
        return itemType;
    }

    public void setItemType(Short itemType) {
        this.itemType = itemType;
    }

    public Short getItemState() {
        return itemState;
    }

    public void setItemState(Short itemState) {
        this.itemState = itemState;
    }

    public String getItemContent() {
        return itemContent;
    }

    public void setItemContent(String itemContent) {
        this.itemContent = itemContent;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public Boolean getaRight() {
        return aRight;
    }

    public void setaRight(Boolean aRight) {
        this.aRight = aRight;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public Boolean getbRight() {
        return bRight;
    }

    public void setbRight(Boolean bRight) {
        this.bRight = bRight;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public Boolean getcRight() {
        return cRight;
    }

    public void setcRight(Boolean cRight) {
        this.cRight = cRight;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public Boolean getdRight() {
        return dRight;
    }

    public void setdRight(Boolean dRight) {
        this.dRight = dRight;
    }

    public String getOptionE() {
        return optionE;
    }

    public void setOptionE(String optionE) {
        this.optionE = optionE;
    }

    public Boolean geteRight() {
        return eRight;
    }

    public void seteRight(Boolean eRight) {
        this.eRight = eRight;
    }

    public Short getCompleteNumber() {
        return completeNumber;
    }

    public void setCompleteNumber(Short completeNumber) {
        this.completeNumber = completeNumber;
    }

    public String getaComplete() {
        return aComplete;
    }

    public void setaComplete(String aComplete) {
        this.aComplete = aComplete;
    }

    public String getbComplete() {
        return bComplete;
    }

    public void setbComplete(String bComplete) {
        this.bComplete = bComplete;
    }

    public String getcComplete() {
        return cComplete;
    }

    public void setcComplete(String cComplete) {
        this.cComplete = cComplete;
    }

    public String getResumeRight() {
        return resumeRight;
    }

    public void setResumeRight(String resumeRight) {
        this.resumeRight = resumeRight;
    }

    public String getSynthesisRight() {
        return synthesisRight;
    }

    public void setSynthesisRight(String synthesisRight) {
        this.synthesisRight = synthesisRight;
    }

    public String getSynthesisRightAttachment() {
        return synthesisRightAttachment;
    }

    public void setSynthesisRightAttachment(String synthesisRightAttachment) {
        this.synthesisRightAttachment = synthesisRightAttachment;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public Short getDegreeOfDifficulty() {
        return degreeOfDifficulty;
    }

    public void setDegreeOfDifficulty(Short degreeOfDifficulty) {
        this.degreeOfDifficulty = degreeOfDifficulty;
    }

    public Short getDegreeOfFrequency() {
        return degreeOfFrequency;
    }

    public void setDegreeOfFrequency(Short degreeOfFrequency) {
        this.degreeOfFrequency = degreeOfFrequency;
    }

    public Short getItemWeight() {
        return itemWeight;
    }

    public void setItemWeight(Short itemWeight) {
        this.itemWeight = itemWeight;
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
        return "QuizItem{" +
                "itemId=" + itemId +
                ", courseId=" + courseId +
                ", unitNumber=" + unitNumber +
                ", stageNumber=" + stageNumber +
                ", questionnaireCode='" + questionnaireCode + '\'' +
                ", itemType=" + itemType +
                ", itemState=" + itemState +
                ", itemContent='" + itemContent + '\'' +
                ", attachment='" + attachment + '\'' +
                ", optionA='" + optionA + '\'' +
                ", aRight=" + aRight +
                ", optionB='" + optionB + '\'' +
                ", bRight=" + bRight +
                ", optionC='" + optionC + '\'' +
                ", cRight=" + cRight +
                ", optionD='" + optionD + '\'' +
                ", dRight=" + dRight +
                ", optionE='" + optionE + '\'' +
                ", eRight=" + eRight +
                ", completeNumber=" + completeNumber +
                ", aComplete='" + aComplete + '\'' +
                ", bComplete='" + bComplete + '\'' +
                ", cComplete='" + cComplete + '\'' +
                ", resumeRight='" + resumeRight + '\'' +
                ", synthesisRight='" + synthesisRight + '\'' +
                ", synthesisRightAttachment='" + synthesisRightAttachment + '\'' +
                ", points='" + points + '\'' +
                ", degreeOfDifficulty=" + degreeOfDifficulty +
                ", degreeOfFrequency=" + degreeOfFrequency +
                ", itemWeight=" + itemWeight +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }
}
