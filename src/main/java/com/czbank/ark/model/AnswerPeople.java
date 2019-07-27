package com.czbank.ark.model;

public class AnswerPeople {
    private Integer answerId;

    private String realName;
    
    private String userName;

    public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	private String affiliation;

    private String age;

    private int score;

    private String phoneNum;
    
    private int isStudent;

    public int getIsStudent() {
		return isStudent;
	}

	public void setIsStudent(int isStudent) {
		this.isStudent = isStudent;
	}

	public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int anwserId) {
        this.answerId = anwserId ;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getphoneNum() {
        return phoneNum;
    }

    public void setphoneNum(String phoneNum) {
        this.phoneNum = phoneNum == null ? null : phoneNum.trim();
    }
}