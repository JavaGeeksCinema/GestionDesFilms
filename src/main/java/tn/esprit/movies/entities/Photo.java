package tn.esprit.movies.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "photo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Photo {

    @Id
    private  String id;

    byte[] image;


    //cloudinary part

//cloudinary part

    String imageUrl;
    String imageId;
    String name;
    String movieId;

}
