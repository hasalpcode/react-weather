package com.esp.spboot.learnspboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Value; // Fix: Correct import statement


@SpringBootApplication
public class LearnspbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnspbootApplication.class, args);
	}

	@RestController
	@RequestMapping(value="/user")
	class DemoController{
		@Value("${name: Hasalp}")
		private String name;

		@GetMapping
		String getName(){
			return "Hello "+name;
		}
	}
	

}
