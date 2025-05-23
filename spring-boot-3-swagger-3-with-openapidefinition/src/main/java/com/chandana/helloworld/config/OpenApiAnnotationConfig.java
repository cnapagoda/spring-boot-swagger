package com.chandana.helloworld.config;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * Configuration class for OpenAPI documentation using {@code @OpenAPIDefinition}.
 * Defines global API information, servers, security requirements, and external documentation.
 */
@OpenAPIDefinition(
    tags = {
        @Tag(name = "greetings", description = "API operations for greetings")
    },
    info = @Info(
        title = "Greetings API",
        version = "1.0.0",
        description = "Greetings API Definition",
        contact = @Contact(
            email = "email@example.com",
            url = "https://blog.napagoda.com",
            name = "Chandana Napagoda"
        ),
        license = @License(
            name = "Apache 2.0",
            url = "http://www.apache.org/licenses/LICENSE-2.0"
        )
    ),
    servers = {
        @Server(url = "http://localhost:8080", description = "Local server")
    },
    externalDocs = @ExternalDocumentation(
        description = "Find out more about Swagger",
        url = "http://swagger.io"
    ),
    security = {
        @SecurityRequirement(name = "bearer key")
    }
)
public class OpenApiAnnotationConfig {

}
