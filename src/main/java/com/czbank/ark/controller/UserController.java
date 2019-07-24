package com.czbank.ark.controller;

import javax.servlet.http.HttpServletRequest;

import org.json.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
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
	public String userLogin(HttpServletRequest request){  
		 String name =request.getParameter("username");
		 String password =request.getParameter("password");
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
