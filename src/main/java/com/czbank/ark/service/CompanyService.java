package com.czbank.ark.service;

import com.czbank.ark.model.Company;

public interface CompanyService {
	Company selectByCompanyName(String companyName);
}
