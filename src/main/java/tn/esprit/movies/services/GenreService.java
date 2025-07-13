package tn.esprit.movies.services;

import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import tn.esprit.movies.entities.Genre;
import tn.esprit.movies.repositories.GenreRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GenreService {

    GenreRepository genreRepository;
    public Genre addGenre(Genre genre) {
        return genreRepository.save(genre);
    }


    public void deleteGenre(String id) {
        genreRepository.deleteById(id);
    }

    public List<Genre> findAllGenres() {
        return genreRepository.findAll();
    }


    public Optional<Genre> findGenreById(String id) {
        return genreRepository.findById(id);
    }


    public List<Genre> findGenresByName(String name) {
        return genreRepository.findByNameContainingIgnoreCase(name);
    }
    public List<Genre> getGenresByMovieId(String movieId) {

            List<Genre> genres = genreRepository.findGenresByMovieId(movieId);
            System.out.println("Genres trouvés : " + genres);
            return genres;


    }


    public Genre updateGenre(String id, Genre updatedGenre) {
        Optional<Genre> existingGenreOpt = genreRepository.findById(id);
        if (existingGenreOpt.isPresent()) {

            return genreRepository.save(updatedGenre);
        } else {
            throw new RuntimeException("Genre not found with id: " + id);
        }
    }
}
