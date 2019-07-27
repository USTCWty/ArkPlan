package com.czbank.ark.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.czbank.ark.dao.BiliboardMapper;
import com.czbank.ark.model.AnswerPeople;
import com.czbank.ark.service.BiliboardService;
@Service
public class BiliboardServiceImpl implements BiliboardService {
	@Autowired BiliboardMapper biliboardMapper;
	@Override
	public List<AnswerPeople> getAnswerRank(int top) {
		
		return biliboardMapper.selectAnswerPeopleRank(top);
	}

}
