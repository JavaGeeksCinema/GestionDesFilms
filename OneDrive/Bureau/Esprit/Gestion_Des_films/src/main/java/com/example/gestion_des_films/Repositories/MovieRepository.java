package com.example.gestion_des_films.Repositories;

import com.example.gestion_des_films.Entities.Movie;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends MongoRepository<Movie,String> {
    List<Movie> findByTitleContainingIgnoreCase(String title);
}
