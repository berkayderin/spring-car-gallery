package com.berkayderin.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = "com.berkayderin")
@EntityScan(basePackages = "com.berkayderin")
@EnableJpaRepositories(basePackages = "com.berkayderin")
@SpringBootApplication
public class SpringCarGalleryAppApplicationStarter {

    public static void main(String[] args) {
        SpringApplication.run(SpringCarGalleryAppApplicationStarter.class, args);
    }

}
