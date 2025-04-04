package br.edu.infnet.silvioluizbassi.api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("API: matrículas de alunos")
                                .version("1.0")
                                .description("API para gestão de matrículas de alunos")
                                .contact(
                                        new Contact()
                                                .name("Equipe de Desenvolvimento")
                                                .email("dev@infnet.com")
                                )
                );
    }
}
