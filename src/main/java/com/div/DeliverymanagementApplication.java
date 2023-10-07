package com.div;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
//@OpenAPIDefinition(
//		info = @Info(title = "Delivery-Management",
//		version = "1.0.0",
//		description = "This project is only for learning",
//		termsOfService = "7patik",
//		contact = @Contact(
//				name = "Togrul",
//				email = "toghrul.ismayilzadeh@gmail.com"
//		))
//)
public class DeliverymanagementApplication{


	public static void main(String[] args) {
		SpringApplication.run(DeliverymanagementApplication.class, args);
	}



}
