package com.salat23.wafflesfullstack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class WafflesFullstackApplication {

    public static void main(String[] args) {
        SpringApplication.run(WafflesFullstackApplication.class, args);
    }//////////

}

//TODO: Поиск транслитом, неправильной раскладкой, другие языки
//TODO: Фильтры, жанры, дата
//TODO: Комментарии