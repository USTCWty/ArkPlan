package com.czbank.ark.service;

import org.apache.ibatis.annotations.Update;

import com.czbank.ark.model.Company;

public interface CompanyService {
	Company selectByCompanyName(String companyName);
	int insertCompany(Company company);
	int  updateCompany(Company company);
}
