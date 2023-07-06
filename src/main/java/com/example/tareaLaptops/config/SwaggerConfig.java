package com.example.tareaLaptops.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import java.util.Collections;

@Configuration
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiDetails())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.tareaLaptops")) // Paquete donde se encuentran los controladores de tu aplicación
                .paths(PathSelectors.any())
                .build()

                ;
    }

    private ApiInfo apiDetails() {
        return new ApiInfo("spring boot api rest",
                "Lybrary api rest",
                "1.0.",
                "www.google.com",
                new Contact("jose",
                        "www.google.com",
                        "jocguada@gmail.com"),
                "MIT",
                "http://www.google.com",Collections.emptyList());


                /**.title("API Documentation") // Título de la documentación
                .description("API documentation for Spring Boot application") // Descripción de la documentación
                .version("1.0.0") // Versión de la API
                .build();
                 */
    }
}