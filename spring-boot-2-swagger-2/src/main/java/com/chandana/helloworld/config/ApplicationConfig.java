package com.chandana.helloworld.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for OpenAPI API documentation.
 * Defines the general API information such as title, version, contact, and license.
 */
@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "Greeting Api Title",
        version = "1.0.0",
        description = "Greeting Api Definition",
        license = @License(name = "Apache 2.0", url = "http://www.apache.org/licenses/LICENSE-2.0"),
        contact = @Contact(name = "Chandana Napagoda", url = "http://blog.napagoda.com", email = "cnapagoda@gmail.com")
    )
)
public class ApplicationConfig {

}
