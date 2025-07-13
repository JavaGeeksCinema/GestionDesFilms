package tn.esprit.movies.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.movies.entities.Artist;
import tn.esprit.movies.repositories.ArtistRepository;


import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ArtistService {
    ArtistRepository artistRepository;

    public Artist addArtist(Artist artist) {

       
        return artistRepository.save(artist);
    }


    public void deleteArtist(String id) {
        artistRepository.deleteById(id);
    }

    public List<Artist> findAllArtists() {
        return artistRepository.findAll();
    }


    public Optional<Artist> findArtistById(String id) {
        return artistRepository.findById(id);
    }

    public List<Artist> findArtistsByName(String name) {
        return artistRepository.findByFirstnameContainingIgnoreCase(name);
    }

    public Artist updateArtist( String id, Artist Artist) {
        Optional<Artist> existingArtistOpt = artistRepository.findById(id);
        if (existingArtistOpt.isPresent()) {

            return artistRepository.save(Artist);
        } else {
            throw new RuntimeException("Artist not found with id: " + id);
        }
    }
}
