package com.example.orderAI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
public class OrderAiApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderAiApplication.class, args);
	}

	@RequestMapping
	@ResponseBody
	public String home(){
		return "OrderAI";
	}

}
