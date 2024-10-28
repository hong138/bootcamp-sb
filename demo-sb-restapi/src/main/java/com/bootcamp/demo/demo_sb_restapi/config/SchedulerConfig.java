package com.bootcamp.demo.demo_sb_restapi.config;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerConfig {
  
  // @Scheduled(fixedRate = 5000)
  public void sayHello() throws Exception {
    System.out.println("Task A Starts. time=" + System.currentTimeMillis());
    Thread.sleep(4000);
    System.out.println("Task A Ends. time=" + System.currentTimeMillis());
  }

  // @Scheduled(fixedRate = 4000)
  // public void sayBye() {
  //   System.out.println("Task B Bye!!!");
  // }

  @Scheduled(fixedRate = 3000) // 3000ms = 3s
  public void sayBye() throws Exception {
    System.out.println("Task B Start. Time: " + System.currentTimeMillis());
    Thread.sleep(3000);
    System.out.println("Task B End. Time: " + System.currentTimeMillis());
  }
}
