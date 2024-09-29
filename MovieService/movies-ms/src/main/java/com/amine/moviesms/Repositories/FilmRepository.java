package com.amine.moviesms.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.amine.moviesms.Entities.Film;

import java.util.List;

@Repository
public interface FilmRepository extends MongoRepository<Film, String> {
    List<Film> findByTitleContainingIgnoreCase(String title);
    List<Film> findByGenresContainingIgnoreCase(String genre);
    List<Film> findByCountriesContainingIgnoreCase(String country);
    List<Film> findByLanguagesContainingIgnoreCase(String language);
    List<Film> findByReleaseYearGreaterThanEqual(int releaseYear);
}
