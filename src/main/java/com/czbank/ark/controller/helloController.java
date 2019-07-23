package com.czbank.ark.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.czbank.ark.service.HelloService;

@RestController
@RequestMapping("/index")  
public class helloController {
	@Autowired
	private HelloService helloservice;
	@RequestMapping
	public String defalut(){
		return "default";
	}
	@RequestMapping("/hello")    
	public int Hello(){       
		  return helloservice.printhello();
	}
	
	@RequestMapping("/world")    
	public String World(){       
		return "world !";   
	}
	
	@RequestMapping("/myworld")    
	public String myWorld(){       
		return "myworld !";   
	}
	
}
