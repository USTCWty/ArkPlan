package com.czbank.ark.dao;

import com.czbank.ark.model.AnswerSubject;

public interface AnswerSubjectMapper {
    int insert(AnswerSubject record);

    int insertSelective(AnswerSubject record);
}