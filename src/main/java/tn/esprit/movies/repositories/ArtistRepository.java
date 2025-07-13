package tn.esprit.movies.repositories;


import org.springframework.data.mongodb.repository.MongoRepository;
import tn.esprit.movies.entities.Artist;

import java.util.List;

public interface ArtistRepository extends MongoRepository<Artist,String>{


    List<Artist> findByFirstnameContainingIgnoreCase(String title);
}
