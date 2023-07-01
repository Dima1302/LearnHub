package com.example.LearnHub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.example.LearnHub.repositories")
@SpringBootApplication
public class LearnHubApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnHubApplication.class, args);
	}

}
