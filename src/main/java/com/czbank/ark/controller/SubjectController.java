package com.czbank.ark.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.czbank.ark.model.Subject;
import com.czbank.ark.model.SubjectType;
import com.czbank.ark.service.SubjectService;

@RestController
public class SubjectController {
	@Autowired
	SubjectService subjectService;

	@RequestMapping("/getSubject")
	public List<Subject> getSubject(HttpServletRequest request) {
		String type = request.getParameter("type");
		String keyword = request.getParameter("keyword");
		// 通过类型查询；通过关键字查询；查询全部
		if (type != null && type.length() > 0) {
			return subjectService.getSubjectByType(type);
		} else if (keyword != null && keyword.length() > 0) {
			return subjectService.getSubjectByKeyWord(keyword);
		} else {
			return subjectService.getAllSubject();
		}
	}

	@RequestMapping("/getSubjectType")
	public List<SubjectType> getType(HttpServletRequest request) {
		return subjectService.getSubjectType();
	}

	@RequestMapping("/insertSubject")
	public void addSubject(@RequestBody Map<String, String> map) {
		String subjectName = map.get("subjectName").toString();
		String companyName = map.get("companyName").toString();
		String subjectContent = map.get("subjectContent").toString();
		String subjectType = map.get("subjectType").toString();
		String startDate = map.get("startDate").toString();
		String endDate = map.get("endDate").toString();
		Subject subject = new Subject();
		subject.setCompanyName(companyName);
		subject.setSubjectName(subjectName);
		subject.setSubjectContent(subjectContent);
		subject.setStartDate(startDate);
		subject.setEndDate(endDate);
		subject.setSubjectType(subjectType);

		subjectService.addSubject(subject);
	}

	@RequestMapping("/updateSubject")
	public void updateSubject(@RequestBody Map<String, String> map) {
		int subjectId = Integer.parseInt(map.get("subjectId").toString());
		String subjectName = map.get("subjectName").toString();
		String companyName = map.get("companyId").toString();
		String subjectContent = map.get("subjectContent").toString();
		String subjectType = map.get("subjectType").toString();
		String startDate = map.get("startDate").toString();
		String endDate = map.get("endDate").toString();
		int scanNum = Integer.parseInt(map.get("scanNum").toString());
		int answerNum = Integer.parseInt(map.get("answerNum").toString());
		Subject subject = new Subject();
		subject.setSubjectId(subjectId);
		subject.setCompanyName(companyName);
		subject.setSubjectName(subjectName);
		subject.setSubjectContent(subjectContent);
		subject.setStartDate(startDate);
		subject.setEndDate(endDate);
		subject.setSubjectType(subjectType);
		subject.setAnswerNum(answerNum);
		subject.setScanNum(scanNum);
		subjectService.updateSubject(subject);
	}

	@RequestMapping("/getSubjectRank")
	public List<Subject> getSubjectRank(HttpServletRequest request) {
		String topString = request.getParameter("top");
		int top = 10;
		if (topString != null && topString.length() > 0) {
			top = Integer.parseInt(topString);
		}
		return subjectService.getSubjectRank(top);
	}
	
	@RequestMapping("/getCompanySubject")
	public List<Subject> getSubjectByCompany(HttpServletRequest request) {
		String companyName = request.getParameter("companyName");
		return subjectService.getSubjectByCompany(companyName);
	}
	
	@RequestMapping("/getAnswerSubject")
	public List<Subject> getSubjectByAnswer(HttpServletRequest request) {
		String answerName = request.getParameter("answerName");
		return subjectService.getSubjectByAnswer(answerName);
	}
	
	
	@ResponseBody
	@RequestMapping("/uploadFile")
	public String upload(@RequestParam("file") MultipartFile file) {
		if (file.isEmpty()) {
			return "上传失败，请选择文件";
		}

		String fileName = file.getOriginalFilename();
		String filePath = "D:/fileTest/";
		File dest = new File(filePath + fileName);
		try {
			file.transferTo(dest);
			return "上传成功";
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "上传失败！";
	}
}
