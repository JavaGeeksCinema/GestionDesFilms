package tn.esprit.movies.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.movies.entities.Movie;
import tn.esprit.movies.entities.Photo;
import tn.esprit.movies.repositories.MovieRepository;
import tn.esprit.movies.repositories.PhotoRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class PhotoService {
    PhotoRepository photoRepository;
    MovieRepository movieRepository;
    public Photo add(byte[] image, String id_movie) {
        Movie movie= movieRepository.findById(id_movie).get();
        Photo photo = new Photo();
        photo.setImage(image);
        photo.setMovieId(id_movie);
        return photoRepository.save(photo);
    }




    public Optional<Photo> get(String id) {
        return photoRepository.findById(id);
    }

    public void delete(String id) {
        photoRepository.deleteById(id);
    }



    public void save(Photo image) {
        photoRepository.save(image);
    }




}
