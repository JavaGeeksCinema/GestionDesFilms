package com.example.gestion_des_films.Repositories;

import com.example.gestion_des_films.Entities.Genre;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepository extends MongoRepository<Genre,String> {
    List<Genre> findByNameContainingIgnoreCase(String name);
}
