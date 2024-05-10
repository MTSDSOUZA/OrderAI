package com.example.orderAI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@Controller
@EnableCaching
@OpenAPIDefinition(
	info = @Info(
		title = "API do Order AI",
		description = "App de pedidos para varejo",
		contact = @Contact(name = "Kauê Braz", email = "rm97768@fiap.com.br"),
		version = "1.0.0"
	)
)
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
