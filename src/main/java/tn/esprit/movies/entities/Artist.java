package tn.esprit.movies.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Document(collection = "artists")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Artist {
    @Id
    private String id;
    private String firstname;
    private String lastname;
    private String role;
    private Date birthDate;
    private String biography;
}
