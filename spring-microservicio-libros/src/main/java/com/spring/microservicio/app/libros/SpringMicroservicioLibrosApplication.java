package com.spring.microservicio.app.libros;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//@EntityScan("{com.spring.microservicio.app.commons.models.entity}")
@EnableEurekaClient
@SpringBootApplication
public class SpringMicroservicioLibrosApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMicroservicioLibrosApplication.class, args);
	}

}
