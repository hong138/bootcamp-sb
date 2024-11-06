package com.bootcamp.demo.demo_thylemeaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class DemoThylemeafApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoThylemeafApplication.class, args);
	}

}
