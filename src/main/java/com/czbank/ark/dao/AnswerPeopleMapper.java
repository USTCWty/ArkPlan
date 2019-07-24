package com.czbank.ark.dao;

import org.apache.ibatis.annotations.Select;

import com.czbank.ark.model.AnswerPeople;

public interface AnswerPeopleMapper {
    int deleteByPrimaryKey(String anwserId);

    int insert(AnswerPeople record);

    int insertSelective(AnswerPeople record);

    AnswerPeople selectByPrimaryKey(String anwserId);

    int updateByPrimaryKeySelective(AnswerPeople record);

    int updateByPrimaryKey(AnswerPeople record);

}