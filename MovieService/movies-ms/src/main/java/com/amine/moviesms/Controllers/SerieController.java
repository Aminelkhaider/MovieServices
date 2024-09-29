package com.amine.moviesms.Controllers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import com.amine.moviesms.Entities.Comment;
import com.amine.moviesms.Entities.Episode;
import com.amine.moviesms.Entities.Serie;
import com.amine.moviesms.Services.SerieService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/series")

public class SerieController {

    private final SerieService serieService;

    public SerieController(SerieService serieService) {
        this.serieService = serieService;
    }
    

    @GetMapping("/{id}")
    public ResponseEntity<Serie> getSerieById(@PathVariable String id) {
        Serie serie = serieService.findById(id);
        if (serie == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(serie);
    }

    @GetMapping

    public List<Serie> getAllSeries() {

        return serieService.findAll();
    }
    @GetMapping("/public")
    public String Hello () {

       return "Public content";
    }
    
    @GetMapping("/test")
    public List<String> test() throws IOException {
        String url = "https://akwam.in/movies";
        List<String> boxLinks = new ArrayList<>();

        Document doc = Jsoup.connect(url).get();
        Elements elements = doc.select("a.box");
        for (Element element : elements) {
            String link = element.absUrl("href");
            boxLinks.add(link);
        }
        return boxLinks;
    }

    @PostMapping
    public ResponseEntity<Serie> createSerie(@RequestBody Serie serie) {

        serieService.save(serie);
        return ResponseEntity.status(HttpStatus.CREATED).body(serie);
    }
    @PostMapping("/{id}/comments")
    public ResponseEntity<?> addComment(@PathVariable String id, @RequestBody Comment comment) {
        Serie serie = serieService.findById(id);
        if (serie == null) {
            return ResponseEntity.notFound().build();
        }
        serie.getComments().add(comment);
        Serie updatedSerie = serieService.save(serie);
        return ResponseEntity.ok(updatedSerie);
    }
    @PostMapping("/{id}/episodes")
    public ResponseEntity<Serie> addEpisodeToSerie(@PathVariable String id, @RequestBody Episode episode) {
        Serie optionalSerie = serieService.findById(id);

        if (optionalSerie!=null) {
            Serie serie = optionalSerie;
            List<Episode> episodes = serie.getEpisodes();
            episodes.add(episode);
            serie.setEpisodes(episodes);

            serieService.save(serie);
            return ResponseEntity.ok().body(serie);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



    @PutMapping("/{id}")
    public ResponseEntity<Serie> updateSerie(@PathVariable String id, @RequestBody Serie updatedSerie) {
        Serie existingSerie = serieService.findById(id);
        if (existingSerie == null) {
            return ResponseEntity.notFound().build();
        }
        updatedSerie.setId(existingSerie.getId());
        serieService.save(updatedSerie);
        return ResponseEntity.ok(updatedSerie);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSerie(@PathVariable String id) {
        Serie existingSerie = serieService.findById(id);
        if (existingSerie == null) {
            return ResponseEntity.notFound().build();
        }
        serieService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

