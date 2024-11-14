package com.martin.api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {

  @Bean
  public OpenAPI customOpenAPI() {
    return new OpenAPI()
        .info(new Info()
            .title("URL Shortening Service API")
            .description("API Rest Challenge de roadmap.sh para la creacion de Short Url y "
                + "guardado en base de datos")
            .contact(new Contact()
                .name("Martin Palomino")
                .email("martinchrispc@hotmail.com")
                .url("https://github.com/MartinpcDev"))
            .license(new License()
                .name("Martin Palomino")
                .url("https://github.com/MartinpcDev"))
        );
  }
}
