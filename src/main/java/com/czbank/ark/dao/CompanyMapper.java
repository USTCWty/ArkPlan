package com.czbank.ark.dao;

import com.czbank.ark.model.Company;

public interface CompanyMapper {
    int deleteByPrimaryKey(String companyId);

    int insert(Company record);

    int insertSelective(Company record);

    Company selectByPrimaryKey(String companyId);

    int updateByPrimaryKeySelective(Company record);

    int updateByPrimaryKey(Company record);
}