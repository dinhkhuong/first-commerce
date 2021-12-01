package com.khuong.firstcommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
//@SpringBootApplication
public class FirstCommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstCommerceApplication.class, args);
	}

}
