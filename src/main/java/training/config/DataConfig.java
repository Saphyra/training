package training.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import training.data.CssMenu;
import training.data.HtmlMenu;
import training.data.IndexMenu;

@Configuration
public class DataConfig {

    @Bean
    public IndexMenu indexMenu(){
        IndexMenu service = new IndexMenu("books");
        service.init();
        return service;
    }

    @Bean
    public HtmlMenu htmlMenu(){
        HtmlMenu service = new HtmlMenu("training/html/chapters");
        service.init();
        return service;
    }

    @Bean
    public CssMenu cssMenu(){
        CssMenu service = new CssMenu("training/css/chapters");
        service.init();
        return service;
    }
}
