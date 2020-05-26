package br.com.g3.sistemadevagaseng.config;

import br.com.g3.sistemadevagaseng.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {
    @Autowired
    private DBService dbService;

    @Bean
    public boolean iniciar(){
        dbService.iniciarDatabase();
        return true;
    }
}
