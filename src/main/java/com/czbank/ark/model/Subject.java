 package com.czbank.ark.model;

public class Subject {
    private int subjectId;
    
    private String subjectName;

    public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	private String subjectContent;

    private String scanNum;

    private String subjectType;

    private String companyId;

    private String answerNum;

    private String answerId;

    private String startDate;

    private String endDate;

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId ;
    }

    public String getSubjectContent() {
        return subjectContent;
    }

    public void setSubjectContent(String subjectContent) {
        this.subjectContent = subjectContent == null ? null : subjectContent.trim();
    }

    public String getScanNum() {
        return scanNum;
    }

    public void setScanNum(String scanNum) {
        this.scanNum = scanNum == null ? null : scanNum.trim();
    }

    public String getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(String subjectType) {
        this.subjectType= subjectType == null ? null : subjectType.trim();
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    public String getAnswerNum() {
        return answerNum;
    }

    public void setAnswerNum(String answerNum) {
        this.answerNum = answerNum == null ? null : answerNum.trim();
    }

    public String getAnswerId() {
        return answerId;
    }

    public void setAnswerId(String answerId) {
        this.answerId = answerId == null ? null : answerId.trim();
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate == null ? null : startDate.trim();
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate == null ? null : endDate.trim();
    }
}