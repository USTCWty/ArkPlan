package com.czbank.ark.model;

public class AnswerPeople {
    private Integer anwserId;

    private String answerName;

    private String affiliation;

    private String age;

    private String score;

    private String corresponding;

    public int getAnwserId() {
        return anwserId;
    }

    public void setAnwserId(int anwserId) {
        this.anwserId = anwserId ;
    }

    public String getAnswerName() {
        return answerName;
    }

    public void setAnswerName(String answerName) {
        this.answerName = answerName == null ? null : answerName.trim();
    }

    public String getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation == null ? null : affiliation.trim();
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age == null ? null : age.trim();
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score == null ? null : score.trim();
    }

    public String getCorresponding() {
        return corresponding;
    }

    public void setCorresponding(String corresponding) {
        this.corresponding = corresponding == null ? null : corresponding.trim();
    }
}