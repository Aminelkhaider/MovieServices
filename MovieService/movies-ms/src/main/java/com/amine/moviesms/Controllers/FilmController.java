package com.amine.moviesms.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.amine.moviesms.Entities.Comment;
import com.amine.moviesms.Entities.Film;
import com.amine.moviesms.Repositories.CommentRepository;
import com.amine.moviesms.Services.FilmService;

import java.util.List;

@RestController
@RequestMapping("/films")
public class FilmController {
    @Autowired
    private FilmService filmService;
    @Autowired
    private CommentRepository commentRepository;

    @GetMapping("")
    public List<Film> getAllFilms() {
        return filmService.findAll();
    }

    @GetMapping("/search")
    public List<Film> searchFilms(@RequestParam("keyword") String keyword) {
        return filmService.searchFilms(keyword);
    }

    @GetMapping("/year")
    public List<Film> getFilmsByReleaseYear(@RequestParam("releaseYear") int releaseYear) {
        return filmService.getFilmsByReleaseYear(releaseYear);
    }

    @GetMapping("/{id}")
    public Film getFilmById(@PathVariable("id") String id) {
        return filmService.getFilmById(id);
    }

    @PostMapping("")
    public Film addFilm(@RequestBody Film film) {
        return filmService.addFilm(film);
    }

    @DeleteMapping("/{id}")
    public void deleteFilm(@PathVariable("id") String id) {
        filmService.deleteFilm(id);
    }
    @PatchMapping("/{id}/add-video-url")
    public Film addVideoUrl(@PathVariable("id") String id, @RequestBody String videoUrl) {
        Film film = filmService.getFilmById(id);
        film.getVideoUrl().add(videoUrl);
        return filmService.updateFilm(id, film);
    }

    @PutMapping("/{id}")
    public Film updateFilm(@PathVariable("id") String id, @RequestBody Film film) {
        return filmService.updateFilm(id, film);
    }

    @PostMapping("/{id}/comments")
    public ResponseEntity<Film> addComment(@PathVariable("id") String id, @RequestBody Comment comment) {
        try {
            Film film = filmService.getFilmById(id);
            Comment comment1= commentRepository.save(comment);
            film.getComments().add(comment1);
            return new  ResponseEntity<Film>(filmService.updateFilm(id, film), HttpStatus.CREATED);
        }
        catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity("Serie dont exists", HttpStatus.NOT_FOUND);
        }


    }

}

