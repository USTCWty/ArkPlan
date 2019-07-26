package com.czbank.ark.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.czbank.ark.dao.SubjectMapper;
import com.czbank.ark.model.Subject;
import com.czbank.ark.model.SubjectType;
import com.czbank.ark.service.SubjectService;
@Service
public class SubjectServiceImpl implements SubjectService {
	@Autowired SubjectMapper subjectMapper;
	public List<Subject> getSubjectByType(String type) {		
		return subjectMapper.selectSubjectByType(type);
	}

	public List<Subject> getSubjectByKeyWord(String keyword) {
		// TODO Auto-generated method stub
		return subjectMapper.selectSubjectByKeyword(keyword);
	}

	public int addSubject(Subject subject) {
		return subjectMapper.inserSubject(subject);
	}

	public int updateSubject(Subject subject) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Subject> getAllSubject() {		
		return subjectMapper.selectAllSubject();
	}

	@Override
	public List<SubjectType> getSubjectType() {
		// TODO Auto-generated method stub
		List<SubjectType> typeList =subjectMapper.selectSubjectType();
		if(typeList!=null&&typeList.size()>0){
			return typeList;
		}
		return null;
	}

}
