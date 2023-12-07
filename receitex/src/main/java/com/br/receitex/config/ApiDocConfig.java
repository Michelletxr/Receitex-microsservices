package com.br.receitex.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiDocConfig {

    public Info infoApi(){
        return new Info()
                .description("Uma API para gerenciamento de receitas!")
                .title("Receitex service API REST")
                .version("V1.0.0");
    }

    @Bean
    public OpenAPI openApiInformation() {
        return new OpenAPI().info(infoApi());
    }


}