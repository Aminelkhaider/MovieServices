package com.movieservices.recommendation.openfeign;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.movieservices.recommendation.models.Film;

import java.util.List;

@FeignClient(name="movies-ms")
public interface MoviesRestClient {
    @GetMapping("/films")
    List<Film> getFilms();
    @GetMapping("/films/search")
    List<Film> getFilmsByGenre(@RequestParam("keyword" ) String keyword);


}
