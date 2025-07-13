package tn.esprit.movies.entities;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Document(collection = "movies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Movie implements Serializable {

    @Id
    private String id;

    private String title;

    private String trailerUrl;

    private String acteurs;
    private String description;

    private String imageId;

    private LocalDate releaseDate;
    private Double rating;
    private Integer duration;

    private List<String> genreIds;



}
