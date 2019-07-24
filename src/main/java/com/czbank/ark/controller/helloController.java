package com.czbank.ark.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/index")  
public class helloController {
	
	@RequestMapping
	public String defalut(){
		return "default";
	}
	@RequestMapping("/hello")    
	public int Hello(){       
		  return 999;
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
