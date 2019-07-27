package com.czbank.ark.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.czbank.ark.model.AnswerPeople;
import com.czbank.ark.service.BiliboardService;

@RestController 
public class BiliboardController {
	@Autowired BiliboardService biliboardService;
	
	@RequestMapping("/getAnswerRank")	
	public List<AnswerPeople>  getSubjectRank(HttpServletRequest request){
		String topString =request.getParameter("top");
		int top=10;
	    if(topString!=null &&topString.length()>0){
	    	top =Integer.parseInt(topString);
	    }
		return biliboardService.getAnswerRank(top) ;
	}
}
