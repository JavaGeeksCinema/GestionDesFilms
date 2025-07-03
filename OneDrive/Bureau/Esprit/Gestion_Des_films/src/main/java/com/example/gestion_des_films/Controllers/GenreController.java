package com.example.gestion_des_films.Controllers;

import com.example.gestion_des_films.Entities.Genre;
import com.example.gestion_des_films.Services.GenreService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genres")

public class GenreController {


    private final GenreService genreService;
    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }


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
}
