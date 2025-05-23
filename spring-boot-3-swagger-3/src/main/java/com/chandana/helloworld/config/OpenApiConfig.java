package com.chandana.helloworld.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for OpenAPI documentation using SpringDoc.
 * Defines custom API information and groups APIs.
 */
@Configuration
public class OpenApiConfig {

        /**
         * Customizes the OpenAPI information.
         * @return OpenAPI object with custom info.
         */
        @Bean
        public OpenAPI customOpenAPI() {
                return new OpenAPI()
                                .info(new Info()
                                                .title("Greetings API Title")
                                                .description("Greetings API Definition")
                                                .version("1.0.0")
                                                .contact(new Contact()
                                                                .name("Chandana Napagoda")
                                                                .url("https://blog.napagoda.com")
                                                                .email("email@example.com"))
                                                .license(new License()
                                                                .name("Apache 2.0")
                                                                .url("http://www.apache.org/licenses/LICENSE-2.0")));
        }

        /**
         * Defines a public API group for paths under "/api/**".
         * @return GroupedOpenApi object for the public API group.
         */
        @Bean
        public GroupedOpenApi publicApi() {
                return GroupedOpenApi.builder()
                                .group("1.0.0")
                                .pathsToMatch("/api/**")
                                .build();
        }
}