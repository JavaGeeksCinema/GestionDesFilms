package com.example.gestion_des_films.Services;

import com.example.gestion_des_films.Entities.Movie;
import com.example.gestion_des_films.Repositories.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MovieService {


    @Autowired
     MovieRepository movieRepository;
    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }


    public void deleteMovie(String id) {
        movieRepository.deleteById(id);
    }

    public List<Movie> findAllMovies() {
        return movieRepository.findAll();
    }


    public Optional<Movie> findMovieById(String id) {
        return movieRepository.findById(id);
    }

    public List<Movie> findMoviesByTitle(String title) {
        return movieRepository.findByTitleContainingIgnoreCase(title);
    }

    public Movie updateMovie( String id, Movie movie) {
        Optional<Movie> existingMovieOpt = movieRepository.findById(id);
        if (existingMovieOpt.isPresent()) {

            return movieRepository.save(movie);
        } else {
            throw new RuntimeException("Movie not found with id: " + id);
        }
    }

}
