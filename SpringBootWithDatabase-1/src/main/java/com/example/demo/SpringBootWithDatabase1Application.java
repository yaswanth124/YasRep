package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringBootWithDatabase1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithDatabase1Application.class, args);
	}

}
