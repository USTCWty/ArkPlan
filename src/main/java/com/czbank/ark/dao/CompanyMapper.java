package com.czbank.ark.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.czbank.ark.model.Company;
@Mapper
@Repository
public interface CompanyMapper {
    int deleteByPrimaryKey(String companyId);

    int insert(Company record);

    int insertSelective(Company record);

    Company selectByPrimaryKey(String companyId);

    int updateByPrimaryKeySelective(Company record);

    int updateByPrimaryKey(Company record);
    
    @Select("Select * from company where company_name=#{name}")
    Company selectBycompanyName(String companyName);
    
    @Update("update company set company_number = #{companyNumber},idcard= #{idcard},company_url = #{companyUrl},legal_person = #{legalPerson}")
    int updateCompany(Company company);
    
    @Insert("insert into company (company_name) VALUES (#{company})")
    int insertCompany(Company company);
}