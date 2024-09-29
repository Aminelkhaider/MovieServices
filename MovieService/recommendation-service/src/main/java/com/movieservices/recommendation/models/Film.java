package com.movieservices.recommendation.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Film {
    private String title;
    private String description;
    int rating;
    private List<String> genres;
    private int releaseYear;
    private List<String> countries;
    private List<String> languages;
    private List<String> videoUrl;
    private List<View> views;
    private List<Comment> Comments;
}
