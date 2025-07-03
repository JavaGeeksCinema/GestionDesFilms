package com.example.gestion_des_films.Entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.time.LocalDate;
import java.util.List;

@Document(collection = "movies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Movie {


    @Id
    private String id;

    private String title;

    private String trailerUrl;

    private String description;
    //private String actorId;
    //private String directorId;

    private LocalDate releaseDate;
    private Double rating;
    private Integer duration;

    private List<Long> genreIds;

}
