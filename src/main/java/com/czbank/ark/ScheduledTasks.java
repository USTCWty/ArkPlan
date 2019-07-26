package com.czbank.ark;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import com.czbank.ark.service.UserService;

/**  
* @Title: ScheduledTasks.java
* @Package com.czbank.ark
* @Description: 定时任务
* @author wty
* @date 2019年7月23日
* @version V1.0  
*/


@Component
@RestController
public class ScheduledTasks {
   
	@Autowired UserService userService;
    private  static final SimpleDateFormat dataFromat = new SimpleDateFormat("HH:mm:ss");
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);
    @Scheduled(cron="0 0/1 * * * ?")
    public void reportCurrent(){
    	int num =userService.countUser();
        logger.debug("用户人数为"+num);
    }
 
}