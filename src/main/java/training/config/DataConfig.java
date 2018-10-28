package training.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import training.service.data.IndexMenu;

@Configuration
public class DataConfig {

    @Bean
    public IndexMenu bookDescriptionService(){
        IndexMenu service = new IndexMenu("books");
        service.init();
        return service;
    }
}
