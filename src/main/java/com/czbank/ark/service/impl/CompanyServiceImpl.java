package com.czbank.ark.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.czbank.ark.dao.CompanyMapper;
import com.czbank.ark.model.Company;
import com.czbank.ark.service.CompanyService;
@Service
public class CompanyServiceImpl implements CompanyService {
	@Autowired CompanyMapper companyMapper;
	@Override
	public Company selectByCompanyName(String companyName) {
		
		return companyMapper.selectBycompanyName(companyName);
	}

}
