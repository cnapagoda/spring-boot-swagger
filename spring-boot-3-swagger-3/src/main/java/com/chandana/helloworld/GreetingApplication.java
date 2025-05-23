package com.chandana.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main application class for the Greeting Spring Boot application.
 * This application demonstrates Spring Boot 3 with OpenAPI 3 features.
 */
@SpringBootApplication
public class GreetingApplication {

	/**
	 * Main entry point for the Spring Boot application.
	 * @param args Command line arguments.
	 */
	public static void main(String[] args) {
		SpringApplication.run(GreetingApplication.class, args);
	}

}
