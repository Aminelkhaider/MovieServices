package com.amine.moviesms.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Episode {
    private String title;
    private String videoUrl;
    private int rating;
    private List<View> views;
    private int seasonNumber;

}
