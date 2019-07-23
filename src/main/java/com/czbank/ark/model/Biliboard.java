package com.czbank.ark.model;

public class Biliboard {
    private String biliboardId;

    private String enrollDate;

    private String rank;

    private String subjectId;

    private String answerId;

    private String score;

    private String submitDate;

    public String getBiliboardId() {
        return biliboardId;
    }

    public void setBiliboardId(String biliboardId) {
        this.biliboardId = biliboardId == null ? null : biliboardId.trim();
    }

    public String getEnrollDate() {
        return enrollDate;
    }

    public void setEnrollDate(String enrollDate) {
        this.enrollDate = enrollDate == null ? null : enrollDate.trim();
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank == null ? null : rank.trim();
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId == null ? null : subjectId.trim();
    }

    public String getAnswerId() {
        return answerId;
    }

    public void setAnswerId(String answerId) {
        this.answerId = answerId == null ? null : answerId.trim();
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score == null ? null : score.trim();
    }

    public String getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(String submitDate) {
        this.submitDate = submitDate == null ? null : submitDate.trim();
    }
}