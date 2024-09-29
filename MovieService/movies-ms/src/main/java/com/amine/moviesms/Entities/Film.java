package com.amine.moviesms.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document

public class Film {
    @Id
    private String id;
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