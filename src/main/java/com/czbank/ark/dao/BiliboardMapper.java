package com.czbank.ark.dao;

import com.czbank.ark.model.Biliboard;

public interface BiliboardMapper {
    int deleteByPrimaryKey(String biliboardId);

    int insert(Biliboard record);

    int insertSelective(Biliboard record);

    Biliboard selectByPrimaryKey(String biliboardId);

    int updateByPrimaryKeySelective(Biliboard record);

    int updateByPrimaryKey(Biliboard record);
}