package com.spring.microservicio.app.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class SpringMicroservicioConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMicroservicioConfigServerApplication.class, args);
	}

}
