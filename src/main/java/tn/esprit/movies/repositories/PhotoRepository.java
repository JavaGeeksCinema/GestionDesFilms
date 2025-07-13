package tn.esprit.movies.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import tn.esprit.movies.entities.Movie;
import tn.esprit.movies.entities.Photo;

public interface PhotoRepository  extends MongoRepository<Photo,String> {
}
