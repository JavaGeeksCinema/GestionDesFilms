package tn.esprit.movies.repositories;


import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.movies.entities.Genre;

import java.util.List;

public interface GenreRepository extends MongoRepository<Genre,String> {

    @Query("{ 'movieIds': ?0 }")
    List<Genre> findGenresByMovieId(String movieId);

    List<Genre> findByNameContainingIgnoreCase(String name);
    List<Genre> findByIdIn(List<String> genreIds);


}
