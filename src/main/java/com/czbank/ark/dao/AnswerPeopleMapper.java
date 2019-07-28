package com.czbank.ark.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.czbank.ark.model.AnswerPeople;
@Mapper
@Repository
public interface AnswerPeopleMapper {
    int deleteByPrimaryKey(String anwserId);

    int insert(AnswerPeople record);

    int insertSelective(AnswerPeople record);

    AnswerPeople selectByPrimaryKey(String anwserId);

    int updateByPrimaryKeySelective(AnswerPeople record);

    int updateByPrimaryKey(AnswerPeople record);
    
    @Select("select * from answer_people where user_name=#{name}")
    AnswerPeople selectAnswerByName(String name);

}