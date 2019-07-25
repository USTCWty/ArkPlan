package com.czbank.ark.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.czbank.ark.model.Subject;
import com.czbank.ark.service.SubjectService;

@RestController 
public class SubjectController {
	@Autowired SubjectService subjectService;
	@RequestMapping("/getSubject")
	public List<Subject> Spring(HttpServletRequest request){  
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
}
