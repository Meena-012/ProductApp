package com.cts;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan("com.cts.exceptions") // Ensures only this package is scanned
public class ProductCrudOperationEmployeeWithSpringBootApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProductCrudOperationEmployeeWithSpringBootApplication.class, args);
	
	}

}
