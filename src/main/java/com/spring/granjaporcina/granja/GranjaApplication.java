package com.spring.granjaporcina.granja;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.*;

@EnableJpaRepositories
@SpringBootApplication
public class GranjaApplication {

	public static void main(String[] args) {
		SpringApplication.run(GranjaApplication.class, args);
	}

	@GetMapping("/")
	public String index() {
		return "index";
	}
}
