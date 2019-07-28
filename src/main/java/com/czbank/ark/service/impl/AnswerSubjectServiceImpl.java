package com.czbank.ark.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.czbank.ark.dao.AnswerSubjectMapper;
import com.czbank.ark.model.AnswerPeople;
import com.czbank.ark.model.AnswerSubject;
import com.czbank.ark.service.AnswerPeopleService;
import com.czbank.ark.service.AnswerSubjectService;
@Service
public class AnswerSubjectServiceImpl implements AnswerSubjectService {

	@Autowired AnswerSubjectMapper answerSubjectMapper;
	@Override
	public int insertRecord(AnswerSubject answerSubject) {
		// TODO Auto-generated method stub
		return answerSubjectMapper.insertAnswerSubject(answerSubject);
	}
	@Override
	public int updateRecord(AnswerSubject answerSubject) {
		// TODO Auto-generated method stub
		return answerSubjectMapper.updateAnswerSubject(answerSubject);
	}




}
