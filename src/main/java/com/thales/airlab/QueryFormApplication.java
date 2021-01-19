package com.thales.airlab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * This is the Main Driver class to run the Spring Boot Application.
 *
 * This class is annonated with @SpringBootApplication to trigger auto-configuration
 * and component scanning.
 *
 * Design Considerations:
 * <ul>
 * <ol>The .war file should be able to run on its own or deploy as war into a web container, e.g. tomcat.</ol>
 * <ol>The Spring boot application supports MVC pattern. The spring boot application focus on handling the backend request from the view.</ol>
 * <ol>The application should not have any business logic of the view</ol>
 * <ol>For every requests from the view, the application should acknowledge with a response</ol>
 * <ol>Codes should be easily testable.</ol>
 * </ul>
 *
 * Usage:
 *
 * To run the spring boot application from console input:
 * 			Example : Java -jar webapp.war
 *
 * @author Alex
 *
 * */

@SpringBootApplication
public class QueryFormApplication {

	public static void main(String[] args) {
		SpringApplication.run(QueryFormApplication.class, args);
	}

}
