package tn.esprit.movies.controllers;

import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;
import tn.esprit.movies.entities.Genre;
import tn.esprit.movies.services.GenreService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@AllArgsConstructor
@RequestMapping("/filmservice/genres")
public class GenreController {
    GenreService genreService;
    @PostMapping("/add")
    @ResponseBody
    public Genre addGenre(@RequestBody Genre genre) {

        return genreService.addGenre(genre);
    }

    @GetMapping("/all")
    @ResponseBody
    public List<Genre> getAllGenres() {
        return genreService.findAllGenres();
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public Genre getGenreById(@PathVariable String id) {
        return genreService.findGenreById(id)
                .orElseThrow(() -> new RuntimeException("Genre not found with id: " + id));
    }

    @GetMapping("/search/{name}")
    @ResponseBody
    public List<Genre> searchGenresByName(@PathVariable String name) {
        return genreService.findGenresByName(name);
    }

    @PutMapping("/update/{id}")
    @ResponseBody
    public Genre updateGenre(@PathVariable String id, @RequestBody Genre genre) {
        return genreService.updateGenre(id, genre);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void deleteGenre(@PathVariable String id) {
        genreService.deleteGenre(id);
    }

    @GetMapping("/getmovie/{movieId}")
    public List<Genre> getGenresByMovieId(@PathVariable String movieId) {
        return genreService.getGenresByMovieId(movieId);
    }

}
