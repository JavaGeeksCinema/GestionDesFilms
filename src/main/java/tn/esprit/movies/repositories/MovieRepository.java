package tn.esprit.movies.repositories;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import tn.esprit.movies.entities.Genre;
import tn.esprit.movies.entities.Movie;

import java.util.List;


public interface MovieRepository extends MongoRepository<Movie,String> {


    List<Movie> findByTitleContainingIgnoreCase(String title);
}
