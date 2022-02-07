package com.spring.microservicio.app.consultas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableCircuitBreaker
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class SpringMicroservicioConsultasApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMicroservicioConsultasApplication.class, args);
	}

}
