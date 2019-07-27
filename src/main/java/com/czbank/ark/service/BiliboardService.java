package com.czbank.ark.service;

import java.util.List;

import com.czbank.ark.model.AnswerPeople;

public interface BiliboardService {
	List<AnswerPeople> getAnswerRank(int top);
}
