package com.busyzero.easyoj.entity;

import java.time.Instant;

/**
 * 用来记录考卷状况
 * @author 11456
 */
public class QuizRecordItem {
    private static final long serialVersionUID = 78878676127816789L;

    /**测试试卷题目编号*/
    private Long recordItemId;

    /** 考卷编号*/
    private Long recordId;

    /**题目号*/
    private Long itemId;

    /**答案是否正确*/
    private Boolean answer;

    /**答案相似度：千分比*/
    private Integer answerDegree;

    /**是否选择了选项A*/
    private Boolean choiceA;

    /**是否选择了选项B*/
    private Boolean choiceB;

    /**是否选择了选项C*/
    private Boolean choiceC;

    /**是否选择了选项D*/
    private Boolean choiceD;

    /**是否选择了选项E*/
    private Boolean choiceE;

    /**填空A输入*/
    private String aInput;

    /**填空B输入*/
    private String bInput;

    /**填空C输入*/
    private String cInput;

    /**简述题输入*/
    private String resumeInput;

    /**简述题附件*/
    private String resumeInputAttachment;

    /**综合题输入*/
    private String synthesisInput;

    /**综合题输入可以能有附件:一般为图片*/
    private String synthesisInputAttachment;

    /**题型分数*/
    private Short score;

    /**得分*/
    private Short scoreRecord;

    /**题型反馈*/
    private String feedback;

    /**创建时间*/
    private Instant gmtCreate;

    /**最后修改时间*/
    private Instant gmtModified;

    public Long getRecordItemId() {
        return recordItemId;
    }

    public void setRecordItemId(Long recordItemId) {
        this.recordItemId = recordItemId;
    }

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Boolean getAnswer() {
        return answer;
    }

    public void setAnswer(Boolean answer) {
        this.answer = answer;
    }

    public Integer getAnswerDegree() {
        return answerDegree;
    }

    public void setAnswerDegree(Integer answerDegree) {
        this.answerDegree = answerDegree;
    }

    public Boolean getChoiceA() {
        return choiceA;
    }

    public void setChoiceA(Boolean choiceA) {
        this.choiceA = choiceA;
    }

    public Boolean getChoiceB() {
        return choiceB;
    }

    public void setChoiceB(Boolean choiceB) {
        this.choiceB = choiceB;
    }

    public Boolean getChoiceC() {
        return choiceC;
    }

    public void setChoiceC(Boolean choiceC) {
        this.choiceC = choiceC;
    }

    public Boolean getChoiceD() {
        return choiceD;
    }

    public void setChoiceD(Boolean choiceD) {
        this.choiceD = choiceD;
    }

    public Boolean getChoiceE() {
        return choiceE;
    }

    public void setChoiceE(Boolean choiceE) {
        this.choiceE = choiceE;
    }

    public String getaInput() {
        return aInput;
    }

    public void setaInput(String aInput) {
        this.aInput = aInput;
    }

    public String getbInput() {
        return bInput;
    }

    public void setbInput(String bInput) {
        this.bInput = bInput;
    }

    public String getcInput() {
        return cInput;
    }

    public void setcInput(String cInput) {
        this.cInput = cInput;
    }

    public String getResumeInput() {
        return resumeInput;
    }

    public void setResumeInput(String resumeInput) {
        this.resumeInput = resumeInput;
    }

    public String getResumeInputAttachment() {
        return resumeInputAttachment;
    }

    public void setResumeInputAttachment(String resumeInputAttachment) {
        this.resumeInputAttachment = resumeInputAttachment;
    }

    public String getSynthesisInput() {
        return synthesisInput;
    }

    public void setSynthesisInput(String synthesisInput) {
        this.synthesisInput = synthesisInput;
    }

    public String getSynthesisInputAttachment() {
        return synthesisInputAttachment;
    }

    public void setSynthesisInputAttachment(String synthesisInputAttachment) {
        this.synthesisInputAttachment = synthesisInputAttachment;
    }

    public Short getScore() {
        return score;
    }

    public void setScore(Short score) {
        this.score = score;
    }

    public Short getScoreRecord() {
        return scoreRecord;
    }

    public void setScoreRecord(Short scoreRecord) {
        this.scoreRecord = scoreRecord;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
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
        return "QuizRecordItem{" +
                "recordItemId=" + recordItemId +
                ", recordId=" + recordId +
                ", itemId=" + itemId +
                ", answer=" + answer +
                ", answerDegree=" + answerDegree +
                ", choiceA=" + choiceA +
                ", choiceB=" + choiceB +
                ", choiceC=" + choiceC +
                ", choiceD=" + choiceD +
                ", choiceE=" + choiceE +
                ", aInput='" + aInput + '\'' +
                ", bInput='" + bInput + '\'' +
                ", cInput='" + cInput + '\'' +
                ", resumeInput='" + resumeInput + '\'' +
                ", resumeInputAttachment='" + resumeInputAttachment + '\'' +
                ", synthesisInput='" + synthesisInput + '\'' +
                ", synthesisInputAttachment='" + synthesisInputAttachment + '\'' +
                ", score=" + score +
                ", scoreRecord=" + scoreRecord +
                ", feedback='" + feedback + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }
}
