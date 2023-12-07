package com.br.receitex_auth.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiDocConfig {

    public Info infoApi(){
        return new Info()
                .description("Uma API para autentificação!")
                .title("Receitex authentification service API REST\"")
                .version("V1.0.0");
    }

    @Bean
    public OpenAPI openApiInformation() {
        return new OpenAPI().info(infoApi());
    }


}