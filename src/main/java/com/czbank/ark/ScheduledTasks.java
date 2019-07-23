package com.czbank.ark;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**  
* @Title: ScheduledTasks.java
* @Package com.nine.Ark
* @Description: 定时任务
* @author wty
* @date 2019年7月23日
* @version V1.0  
*/


@Component
public class ScheduledTasks {
   
    private  static final SimpleDateFormat dataFromat = new SimpleDateFormat("HH:mm:ss");
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);
    @Scheduled(cron="0 0/10 * * * ?")
    public void reportCurrent(){
        logger.info("现在时间：{}",dataFromat.format(new Date()));
    }
 
}