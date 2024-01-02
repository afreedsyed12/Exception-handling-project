package com.maiora;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

//@EnableWebSecurity
@SpringBootApplication
public class ValidationExceptionHandleingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ValidationExceptionHandleingApplication.class, args);
		
		System.out.print("Running....!");
	}

}
