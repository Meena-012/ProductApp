package com.cts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
public class ProductCrudOperationEmployeeWithSpringBootApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProductCrudOperationEmployeeWithSpringBootApplication.class, args);
		System.out.println("checking");
		System.out.println("changing");
	}

}
