package com.czbank.ark.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.czbank.ark.dao.AnswerPeopleMapper;
import com.czbank.ark.model.AnswerPeople;
import com.czbank.ark.service.AnswerPeopleService;
@Service
public class AnswerPeopleServiceImpl implements AnswerPeopleService {

	@Autowired
	AnswerPeopleMapper answerPeopleMapper;
	@Override
	public AnswerPeople selectAnswerByName(String name) {
		// TODO Auto-generated method stub
		return answerPeopleMapper.selectAnswerByName(name);
	}

}
