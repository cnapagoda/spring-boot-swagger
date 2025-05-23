package com.chandana.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main application class for the Helloworld Spring Boot application.
 */
@SpringBootApplication
public class HelloworldApplication {

	/**
	 * Main entry point for the Spring Boot application.
	 * @param args Command line arguments.
	 */
	public static void main(String[] args) {
		SpringApplication.run(HelloworldApplication.class, args);
	}
}
