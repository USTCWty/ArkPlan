package com.czbank.ark.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.czbank.ark.service.UserService;

@RestController 
public class UserController {
	@Autowired
	UserService userService;
	@RequestMapping("/test")
	public String testSpring(){       
		  return "spring boot is areadly start by wty";
	}
	
	
	@RequestMapping("/count")
	public int conutUser(){
		  return userService.countUser();
	}
	
	@RequestMapping("/login")
	public String userLogin(HttpServletRequest request, @RequestBody Map<String, String> map){ 
		 String name = map.get("username").toString();
		 String password = map.get("password").toString();
		 boolean isUser =userService.isUser(name,password);
		 if(isUser){
			 return "登录成功";
		 }else{
			 return "账号或密码有误";
		 }
		
	}
	@RequestMapping("/getUser")    
	public void userFind(){       
		 userService.getUserById();
				
	}
}
