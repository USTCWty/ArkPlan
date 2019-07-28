package com.czbank.ark.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.czbank.ark.model.Company;
import com.czbank.ark.model.Subject;
import com.czbank.ark.model.User;
import com.czbank.ark.service.CompanyService;
import com.czbank.ark.util.ArkResponse;

@RestController
public class CompanyController {
	@Autowired CompanyService companyService;
	@RequestMapping("/getCompany")
	public Company  getCompany(HttpServletRequest request){
		String companyName =request.getParameter("companyName");
		return companyService.selectByCompanyName(companyName);
	}
	
	@RequestMapping("/updateCompany")
	public ArkResponse updateCompany(@RequestBody Map<String, String> map){
		String companyNum = map.get("companyNumber").toString();
		String idcard = map.get("idcard").toString();
		String companyUrl = map.get("companyUrl").toString();
		String legalPerson=map.get("legalPerson").toString();
		int companyId =Integer.parseInt(map.get("companyId").toString());
		
		Company company =new Company();
		company.setCompanyNumber(companyNum);
		company.setCompanyId(companyId);
		company.setLegalPerson(legalPerson);
		company.setIdcard(idcard);
		company.setCompanyUrl(companyUrl);
		int num = companyService.updateCompany(company);
		ArkResponse response = new ArkResponse();
		if (num == 1) {
			response.setResponseCode(200);
			response.setResponseMsg("成功");
		} else {
			response.setResponseCode(201);
			response.setResponseMsg("更新失败");
		}
		return response;
	}
}
