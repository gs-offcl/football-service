package com.football.league;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class FootballApplication {

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(FootballApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(FootballApplication.class, args);
	}
}
