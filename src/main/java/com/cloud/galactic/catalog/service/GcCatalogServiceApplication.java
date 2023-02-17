package com.cloud.galactic.catalog.service;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GcCatalogServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GcCatalogServiceApplication.class, args);
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().addServersItem(new Server().url("https://api.onepos.com.vn/catalog-service/api/v2"));
    }

}
