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

    private int scanNum;

    private String subjectType;

    private int companyId;

    private int answerNum;

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

    public int getScanNum() {
        return scanNum;
    }

    public void setScanNum(int scanNum) {
        this.scanNum = scanNum;
    }

    public String getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(String subjectType) {
        this.subjectType= subjectType == null ? null : subjectType.trim();
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId ;
    }

    public int getAnswerNum() {
        return answerNum;
    }

    public void setAnswerNum(int answerNum) {
        this.answerNum = answerNum ;
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