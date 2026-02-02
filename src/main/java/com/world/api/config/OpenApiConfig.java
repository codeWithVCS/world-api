package com.world.api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("World Statistics API")
                        .version("1.0.0")
                        .description("A granular RESTful API for exploring countries, cities, and languages around the world.")
                        .contact(new Contact()
                                .name("Chandra Sekhar Vipparla")
                                .email("code.chandrasekhar@gmail.com"))
                        );
    }
}