package training.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import training.service.data.BookDescriptionService;

@Configuration
public class DataConfig {

    @Bean
    public BookDescriptionService bookDescriptionService(){
        BookDescriptionService service = new BookDescriptionService("books.yaml");
        service.init();
        return service;
    }
}
