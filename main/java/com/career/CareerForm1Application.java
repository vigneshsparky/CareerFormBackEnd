package com.career;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan(basePackages = "com.career*")
@SpringBootApplication
public class CareerForm1Application {

	public static void main(String[] args) {
		SpringApplication.run(CareerForm1Application.class, args);
	}
}
