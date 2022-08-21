package com.football.league.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class FootballConfiguration {

	@Value("${football.api.readTimeout:5000}")
	private int readTimeout;

	@Value("${football.api.connectTimeout:5000}")
	private int connectTimeout;

	@Bean
	RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
		return restTemplateBuilder.setConnectTimeout(Duration.ofMillis(connectTimeout))
				.setReadTimeout(Duration.ofMillis(readTimeout)).build();
	}
}
