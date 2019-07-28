package com.czbank.ark.controller;

import java.util.Map;

import org.mybatis.generator.codegen.ibatis2.Ibatis2FormattingUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.czbank.ark.model.AnswerSubject;
import com.czbank.ark.service.AnswerSubjectService;
import com.czbank.ark.util.ArkResponse;

@RestController
public class AnswerSubjectController {
	@Autowired
	AnswerSubjectService AnswerSubjectService;
	@RequestMapping("/inserAnswerSubject")
	public ArkResponse insertRecord(@RequestBody Map<String, String> map) {
		String answerName = map.get("answerName").toString();
		int subjectId = Integer.parseInt(map.get("subjectId").toString());
		AnswerSubject answerSubject =new AnswerSubject();
		answerSubject.setAnswerName(answerName);
		answerSubject.setSubjectId(subjectId);
		ArkResponse response = new ArkResponse();
		if(AnswerSubjectService.insertRecord(answerSubject)==1){
		response.setResponseCode(200);
		response.setResponseMsg("成功");
		}else{
		response.setResponseCode(201);
		response.setResponseMsg("账号或密码有误");
		}
		return response;

	}
}
