package com.czbank.ark.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.czbank.ark.dao.SubjectMapper;
import com.czbank.ark.model.Subject;
import com.czbank.ark.service.SubjectService;
@Service
public class SubjectServiceImpl implements SubjectService {
	@Autowired SubjectMapper subjectMapper;
	public List<Subject> getSubjectByType(String type) {
		// TODO Auto-generated method stub
		
		return subjectMapper.selectSubjectByType(type);
	}

	public List<Subject> getSubjectByKeyWord(String keyword) {
		// TODO Auto-generated method stub
		return subjectMapper.selectSubjectByKeyword(keyword);
	}

	public int addSubject(Subject subject) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateSubject(Subject subject) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Subject> getAllSubject() {
		
		return subjectMapper.selectAllSubject();
	}

}
