package com.czbank.ark.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.czbank.ark.model.Subject;
import com.czbank.ark.model.SubjectType;
import com.czbank.ark.service.SubjectService;

@RestController 
public class SubjectController {
	@Autowired SubjectService subjectService;
	@RequestMapping("/getSubject")
	public List<Subject> getSubject(HttpServletRequest request){  
		  String type =request.getParameter("type");
		  String keyword=request.getParameter("keyword");
		  //通过类型查询；通过关键字查询；查询全部
		  if(type!=null &&type.length()>0){
			  return subjectService.getSubjectByType(type);
		  }else if(keyword!=null && keyword.length()>0){
			  return subjectService.getSubjectByKeyWord(keyword);
		  }else {
			return subjectService.getAllSubject();
		}	 
	}	
	
	@RequestMapping("/getSubjectType")
	public List<SubjectType>  getType(HttpServletRequest request){
		return subjectService.getSubjectType();
	}
	
	@RequestMapping("/insertSubject")
	public void addSubject(@RequestBody Map<String, String> map){
		 String subjectName =map.get("subjectName").toString();
		 String companyId =map.get("companyId").toString();
		 String subjectContent =map.get("subjectContent").toString();
		 String subjectType=map.get("subjectType").toString();
		 String startDate=map.get("startDate").toString();
		 String endDate=map.get("endDate").toString();
		 String scanNum=map.get("scanNum").toString();
		 String answerNum =map.get("answerNum").toString();
		 String answerId=map.get("answerId").toString();
		 Subject subject =new Subject();
		 subject.setCompanyId(companyId);
		 subject.setSubjectName(subjectName);
		 subject.setSubjectContent(subjectContent);
		 subject.setStartDate(startDate);
		 subject.setEndDate(endDate);
		 subject.setSubjectType(subjectType);
		 subject.setAnswerId(answerId);
		 subject.setAnswerNum(answerNum);
		 subject.setScanNum(scanNum);
		 subjectService.addSubject(subject);
	}
	@RequestMapping("/updateSubject")
	public void updateSubject(@RequestBody Map<String, String> map){
		 String subjectName =map.get("subjectName").toString();
		 String companyId =map.get("companyId").toString();
		 String subjectContent =map.get("subjectContent").toString();
		 String subjectType=map.get("subjectType").toString();
		 String startDate=map.get("startDate").toString();
		 String endDate=map.get("endDate").toString();
		 String scanNum=map.get("scanNum").toString();
		 String answerNum =map.get("answerNum").toString();
		 String answerId=map.get("answerId").toString();
		 Subject subject =new Subject();
		 subject.setCompanyId(companyId);
		 subject.setSubjectName(subjectName);
		 subject.setSubjectContent(subjectContent);
		 subject.setStartDate(startDate);
		 subject.setEndDate(endDate);
		 subject.setSubjectType(subjectType);
		 subject.setAnswerId(answerId);
		 subject.setAnswerNum(answerNum);
		 subject.setScanNum(scanNum);
		 subjectService.updateSubject(subject);
	}
}
