package com.alumnos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class AlumnosApplication  extends SpringBootServletInitializer{
	
    
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AlumnosApplication.class);
    } //Esta función nos ayuda a construir y reconocer todas las partes del proyecto de srping, tanto los models, los respositorios y los paquetes
	//que se vayan creando.
	
	public static void main(String[] args) {
		SpringApplication.run(AlumnosApplication.class, args);
	}
}
