package com.czbank.ark.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.czbank.ark.model.AnswerSubject;
@Mapper
@Repository
public interface AnswerSubjectMapper {
   
    @Insert("insert into answer_subject (answer_name,subject_id) VALUES (#{answerName},#{subjectId})")
    int insertAnswerSubject(AnswerSubject answerSubject);
    
    @Update("update answer_subject set answer_content=#{answerContent})")
    int updateAnswerSubject(AnswerSubject answerSubject);
}