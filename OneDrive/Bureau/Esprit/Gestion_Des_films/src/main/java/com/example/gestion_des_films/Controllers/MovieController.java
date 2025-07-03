package com.example.gestion_des_films.Controllers;

import com.example.gestion_des_films.Entities.Movie;
import com.example.gestion_des_films.Services.GenreService;
import com.example.gestion_des_films.Services.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
@AllArgsConstructor
public class MovieController {

    @Autowired
     MovieService movieService;

     GenreService genreService;


    @PostMapping("/add")
    @ResponseBody
    public Movie addMovie(@RequestBody Movie movie) {
        Movie m = movieService.addMovie(movie);
        return m;

    }


    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void deleteMovie(@PathVariable String id) {
        movieService.deleteMovie(id);
    }


    @GetMapping("/all")
    @ResponseBody
    public List<Movie> getAllMovies() {
        return movieService.findAllMovies();
    }


    @GetMapping("/get/{id}")
    @ResponseBody
    public Movie getMovieById(@PathVariable String id) {
        return movieService.findMovieById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found with id: " + id));
    }


    @GetMapping("/search/{title}")
    @ResponseBody
    public List<Movie> searchMoviesByTitle(@PathVariable String title) {
        return movieService.findMoviesByTitle(title);
    }


    @PutMapping("/update/{id}")
    @ResponseBody
    public Movie updateMovie(@PathVariable String id, @RequestBody Movie movie) {
        return movieService.updateMovie(id, movie);
    }
}
