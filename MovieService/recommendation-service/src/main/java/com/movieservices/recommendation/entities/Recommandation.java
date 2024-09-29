package com.movieservices.recommendation.entities;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.movieservices.recommendation.models.Film;
import com.movieservices.recommendation.models.Serie;

import java.util.List;

@Document
public class Recommandation {
    @Id
    String id;
    String userId;
    List<Film> films;
    List<Serie> series;

}
