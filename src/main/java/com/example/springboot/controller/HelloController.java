package com.example.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloController {

	@RequestMapping("/sayhello")
	public String index() {
		return "Hello from Spring Boot!";
	}
	
}
