package com.czbank.ark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class ArkApplication {
 
     public static void main(String[] args) {
         SpringApplication.run(ArkApplication.class, args);
     }
}

