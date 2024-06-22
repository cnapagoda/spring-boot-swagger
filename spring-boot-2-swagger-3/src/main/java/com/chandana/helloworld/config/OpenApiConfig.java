package com.chandana.helloworld.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

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
                                                                .email("cn*****@gmail.com"))
                                                .license(new License()
                                                                .name("Apache 2.0")
                                                                .url("http://www.apache.org/licenses/LICENSE-2.0")));
        }

        @Bean
        public GroupedOpenApi publicApi() {
                return GroupedOpenApi.builder()
                                .group("1.0.0")
                                .pathsToMatch("/api/**")
                                .build();
        }
}