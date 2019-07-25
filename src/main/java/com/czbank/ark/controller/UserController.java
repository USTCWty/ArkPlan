package com.czbank.ark.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.czbank.ark.model.User;
import com.czbank.ark.service.UserService;
import com.czbank.ark.util.ArkResponse;

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
	public ArkResponse userLogin(HttpServletRequest request, @RequestBody Map<String, String> map){ 
		 String name = map.get("username").toString();
		 String password = map.get("password").toString();
		 ArkResponse response =new ArkResponse();
		 boolean isUser =userService.isUser(name,password);
		 if(isUser){
			
			 response.setResponseCode(200);
			 response.setResponseMsg("成功");
		 }else{
			 response.setResponseCode(201);
			 response.setResponseMsg("账号或密码有误");
			
		 }
		 return response;
		
	}
	@RequestMapping("/addUser")    
	
	public void addUser(HttpServletRequest request){
		 String name =request.getParameter("username");
		 String password =request.getParameter("password");
		 String userRole =request.getParameter("role");
		 User user=new User();
		 user.setUserName(name);
		 user.setUserPassword(password);
		 user.setUserRole(userRole);
		 userService.addUser(user);
				
	}
	@RequestMapping("/getUser")    
	public void userFind(){       
		 userService.getUserById();
				
	}
}
