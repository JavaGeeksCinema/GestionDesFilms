package tn.esprit.movies.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.movies.entities.Artist;
import tn.esprit.movies.services.ArtistService;
import tn.esprit.movies.services.ArtistService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@AllArgsConstructor
@RequestMapping("/artists")
public class ArtistController {
    ArtistService artistService;
    @PostMapping("/add")
    @ResponseBody
    public Artist addArtist(@RequestBody Artist Artist) {

        return artistService.addArtist(Artist);
    }

    @GetMapping("/all")
    @ResponseBody
    public List<Artist> getAllArtists() {
        return artistService.findAllArtists();
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public Artist getArtistById(@PathVariable String id) {
        return artistService.findArtistById(id)
                .orElseThrow(() -> new RuntimeException("Artist not found with id: " + id));
    }

    @GetMapping("/search/{name}")
    @ResponseBody
    public List<Artist> searchArtistsByName(@PathVariable String name) {
        return artistService.findArtistsByName(name);
    }

    @PutMapping("/update/{id}")
    @ResponseBody
    public Artist updateArtist(@PathVariable String id, @RequestBody Artist Artist) {
        return artistService.updateArtist(id, Artist);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void deleteArtist(@PathVariable String id) {
        artistService.deleteArtist(id);
    }

}
