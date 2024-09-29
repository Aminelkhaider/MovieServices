package com.amine.moviesms.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.processing.Generated;
import java.util.List;
@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Serie {
    @Id
    private String id;
    private String title;
    private String description;
    private List<String> genres;
    private int releaseYear;
    private int numberOfSeasons;
    private List<String> Countries;
    private List<String> languages;
    private List<Episode> Episodes;
    private List<Comment> Comments;
}
