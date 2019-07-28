package com.czbank.ark.service;

import java.util.*;

import com.czbank.ark.model.Subject;
import com.czbank.ark.model.SubjectType;

public interface SubjectService {
	List<Subject> getSubjectByType(String type); //根据类型获取题目
	List<Subject> getSubjectByKeyWord(String keyword);//根据关键字获取题目
	List<Subject> getAllSubject();//获取全部题目
	int addSubject(Subject subject); //新增题目
	int updateSubject(Subject subject); //更新题目
	List<SubjectType> getSubjectType();// 获取题目类型
	List<Subject> getSubjectRank(int top); //获取题目榜单
	List<Subject> getSubjectByCompany(String companyName);//获取企业题目
	List<Subject> getSubjectByAnswer(String answerName);//获取个人题目
	
	
	
}
