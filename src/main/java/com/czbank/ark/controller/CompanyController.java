package com.czbank.ark.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.czbank.ark.model.Company;
import com.czbank.ark.model.Subject;
import com.czbank.ark.service.CompanyService;

@RestController
public class CompanyController {
	@Autowired CompanyService companyService;
	@RequestMapping("/getCompany")
	public Company  getCompany(HttpServletRequest request){
		String companyName =request.getParameter("companyName");
		return companyService.selectByCompanyName(companyName);
	}
}
