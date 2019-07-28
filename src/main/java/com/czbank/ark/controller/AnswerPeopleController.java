package com.czbank.ark.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.czbank.ark.model.AnswerPeople;
import com.czbank.ark.service.AnswerPeopleService;
import com.czbank.ark.service.UserService;

@RestController
public class AnswerPeopleController {
	@Autowired
	AnswerPeopleService answerPeopleService;

	@RequestMapping("/getAnswer")
	public AnswerPeople getAnswer(HttpServletRequest request) {
		String name =request.getParameter("userName");
		return answerPeopleService.selectAnswerByName(name);
	}
}
