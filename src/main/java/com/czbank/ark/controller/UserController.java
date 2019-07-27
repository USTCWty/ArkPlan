package com.czbank.ark.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

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
	public int countUser(){
		  return userService.countUser();
	}

	
	@RequestMapping("/login")
	public ArkResponse userLogin(@RequestBody Map<String, String> map){ 
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
	
	public ArkResponse addUser(@RequestBody Map<String, String> map){
		 String name =map.get("username").toString();
		 String password =map.get("password").toString();
		 String userRole =map.get("userRole").toString();		 
		 Date date = new Date();
		 SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 String time =dateFormat.format(date).toString();
		 User user=new User();
		 user.setUserName(name);
		 user.setUserPassword(password);
		 user.setUserRole(userRole);
		 user.setSubmitTime(time);
		 int num = userService.addUser(user);	
		 ArkResponse response =new ArkResponse();
		
		 if(num==1){		
			 response.setResponseCode(200);
			 response.setResponseMsg("成功");
		 }else{
			 response.setResponseCode(201);
			 response.setResponseMsg("注册用户失败");			
		 }
		 return response;
	}
	
	@RequestMapping("/getUser")    
	public void userFind(){       
		 userService.getUserById();
				
	}
}
