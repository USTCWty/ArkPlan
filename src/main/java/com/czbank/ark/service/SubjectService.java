package com.czbank.ark.service;

import java.util.*;

import com.czbank.ark.model.Subject;

public interface SubjectService {
	List<Subject> getSubjectByType(String type); //根据类型获取题目
	List<Subject> getSubjectByKeyWord(String keyword);//根据关键字获取题目
	List<Subject> getAllSubject();//获取全部题目
	int addSubject(Subject subject); //新增题目
	int updateSubject(Subject subject); //更新题目
	
	
	
	
}
