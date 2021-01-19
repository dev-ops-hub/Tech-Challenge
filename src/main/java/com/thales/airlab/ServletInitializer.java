package com.thales.airlab;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


/**
 * This ServletInitializer extends from SpringBootServletInitializer to support the
 * SpringApplication running from a WAR deployment or as a Spring Boot applications
 *
 * Usage:
 *
 * To configure the application by override the configure method
 *
 * @author Alex
 *
 * */

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(QueryFormApplication.class);
	}

}
