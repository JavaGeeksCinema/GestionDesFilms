package com.example.gestion_des_films;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("com.example.gestion_des_films.Repositories")
@EntityScan("com.example.gestion_des_films.Entities")

public class GestionDesFilmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionDesFilmsApplication.class, args);
    }


}
