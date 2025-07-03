package com.example.gestion_des_films.Services;

import com.example.gestion_des_films.Entities.Genre;
import com.example.gestion_des_films.Repositories.GenreRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GenreService {

@Autowired
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


    public Genre updateGenre(String id, Genre updatedGenre) {
        Optional<Genre> existingGenreOpt = genreRepository.findById(id);
        if (existingGenreOpt.isPresent()) {

            return genreRepository.save(updatedGenre);
        } else {
            throw new RuntimeException("Genre not found with id: " + id);
        }
    }

}
