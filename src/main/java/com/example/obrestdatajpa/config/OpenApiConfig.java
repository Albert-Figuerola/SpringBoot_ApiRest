package com.example.obrestdatajpa.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Configuración Swagger para la generación de documentación de la API REST
// HTML: http://localhost:8081/swagger-ui/index.html
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI custonOpenAPI(){
        return new OpenAPI().info(new Info()
                .title("Spring Boot Book API REST")
                .version("1.0")
                .description("Library API REST docs")
                .termsOfService("https://www.google.com")
                .license(new License().name("Apache 2.0").url("https://springdoc.org")));
    }

}
