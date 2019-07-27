package com.czbank.ark.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.czbank.ark.model.AnswerPeople;
import com.czbank.ark.model.Biliboard;
@Mapper
@Repository
public interface BiliboardMapper {
    int deleteByPrimaryKey(String biliboardId);

    int insert(Biliboard record);

    int insertSelective(Biliboard record);

    Biliboard selectByPrimaryKey(String biliboardId);

    int updateByPrimaryKeySelective(Biliboard record);

    int updateByPrimaryKey(Biliboard record);
    
    @Select("Select * from answer_people order by score desc limit #{top}" )
    List<AnswerPeople> selectAnswerPeopleRank(int top);
}