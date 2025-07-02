package tn.esprit.movies.services;

import com.mongodb.client.gridfs.model.GridFSFile;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;

import org.springframework.web.multipart.MultipartFile;
import tn.esprit.movies.entities.Genre;
import tn.esprit.movies.entities.Movie;
import tn.esprit.movies.repositories.MovieRepository;
import tn.esprit.movies.repositories.GenreRepository;

import java.io.IOException;
import java.util.*;


@Service
@AllArgsConstructor

public class MovieService {

    MovieRepository movieRepository;
    GenreRepository genreRepository;
     GridFsTemplate gridFsTemplate;
    GridFsOperations operations;

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
public List<Genre> getGenresByMovieId(String movieId) {
        Movie movie = movieRepository.findById(movieId).orElse(null);
        if (movie == null) {
            return Collections.emptyList();
        }
        List<String> genreIds = movie.getGenreIds();
        return genreRepository.findByIdIn(genreIds);
    }
    public String storeMovieImage(String movieId, MultipartFile file) throws IOException {
        // Stocke le fichier dans GridFS
        ObjectId fileId = gridFsTemplate.store(
                file.getInputStream(),
                file.getOriginalFilename(),
                file.getContentType()
        );
        // Lie l’image au film
        Movie m = movieRepository.findById(movieId)
                .orElseThrow(() -> new RuntimeException("Movie not found"));
        m.setImageId(fileId.toString());
        movieRepository.save(m);
        return fileId.toString();
    }

    public GridFsResource getMovieImage(String movieId) {
        Movie m = movieRepository.findById(movieId)
                .orElseThrow(() -> new RuntimeException("Movie not found"));
        String imgId = m.getImageId();
        if (imgId == null) throw new RuntimeException("No image for movie");
        GridFSFile file = gridFsTemplate.findOne(
                new Query(Criteria.where("_id").is(new ObjectId(imgId)))
        );
        return operations.getResource(file);
    }

}
