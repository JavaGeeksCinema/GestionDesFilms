package tn.esprit.movies.controllers;


import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;
import tn.esprit.movies.entities.Genre;
import tn.esprit.movies.entities.Movie;
import tn.esprit.movies.services.MovieService;

import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/filmservice/movies")
public class MovieController {


    MovieService movieService;

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

    @GetMapping("/getgenres/{movieId}")
    public ResponseEntity<List<Genre>> getGenresByMovieId(@PathVariable String movieId) {
        List<Genre> genres = movieService.getGenresByMovieId(movieId);
        if (genres.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(genres);
    }

    @PostMapping("/{id}/image")
    public ResponseEntity<String> uploadImage(
            @PathVariable String id,
            @RequestParam("file") MultipartFile file
    ) throws IOException {
        String fileId = movieService.storeMovieImage(id, file);
        return ResponseEntity.ok(fileId);
    }

    @GetMapping("/{id}/image")
    public void serveImage(@PathVariable String id, HttpServletResponse response) throws IOException {
        GridFsResource img = movieService.getMovieImage(id);
        response.setContentType(img.getContentType());
        StreamUtils.copy(img.getInputStream(), response.getOutputStream());
    }
}
