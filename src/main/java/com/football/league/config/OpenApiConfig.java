package com.football.league.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {

	@Bean
	OpenAPI customOpenAPI() {
		return new OpenAPI().components(new Components()).info(new Info().title("Football Service API")
				.description("This is a Football RESTful Micro service using springdoc-openapi and OpenAPI 3.")
				.termsOfService("terms").contact(new Contact().email("@XYZ.com"))
				.license(new License().name("Apache")).version("2.0"));
	}
}
