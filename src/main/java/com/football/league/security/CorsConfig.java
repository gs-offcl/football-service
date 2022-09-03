package com.football.league.security;

import java.util.Arrays;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {
 
  @Bean
  FilterRegistrationBean<CorsFilter> customCorsFilter() {
	  
    CorsConfiguration corsConfiguration = new CorsConfiguration();
 
    //corsConfiguration.setAllowCredentials(true);
    corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200","http://localhost:8080"));
    corsConfiguration.setAllowedMethods(Arrays.asList(CorsConfiguration.ALL));
    corsConfiguration.setAllowedHeaders(Arrays.asList(CorsConfiguration.ALL));
 
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/api/**", corsConfiguration);
    
	FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(new CorsFilter(source));
    bean.setName("COCO");
    bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
    
    return bean;
  }
}