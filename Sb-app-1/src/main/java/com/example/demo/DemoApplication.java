package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}

@RestController
// @RequestMapping("/user")
// class DemoController{
// 	@Value("${name: Hasalp}")
// 	private String name;

// 	@GetMapping
// 	String getName(){
// 		return "Hello "+name;
// 	}
// }

// @RestController
// @RequestMapping("/user/first")
// class DemoController{
// 	@Value("${user-first: Hasalp}")
// 	private String firstname;

// 	@GetMapping
// 	String getFirstName(){
// 		return firstname;
// 	}
// }


@RequestMapping("/user/last")
class DemoController{
	@Value("${user-last: code}")
	private String lastname;

	@GetMapping
	String getLastName(){
		return lastname;
	}
}


