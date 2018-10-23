package com.david.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class CrudApplication {

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(sources)
	}
	
	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}
}
