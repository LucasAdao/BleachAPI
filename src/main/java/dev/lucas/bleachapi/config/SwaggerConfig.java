package dev.lucas.bleachapi.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI bleachAPI(){
        return new OpenAPI().info(new Info().title("Bleach API").version("1.0.0").license(new License().name("Licensa do Sistema").url("https://github.com/LucasAdao")).description("Api de Treinamento Acadêmico"));
    }
}
