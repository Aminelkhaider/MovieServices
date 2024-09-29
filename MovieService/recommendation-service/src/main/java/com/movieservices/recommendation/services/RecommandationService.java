package com.movieservices.recommendation.services;



import org.springframework.stereotype.Service;

import com.movieservices.recommendation.models.Film;
import com.movieservices.recommendation.models.User;
import com.movieservices.recommendation.openfeign.MoviesRestClient;
import com.movieservices.recommendation.openfeign.UserRestClient;

import java.util.List;

@Service
public class RecommandationService {

    private final UserRestClient userRestClient;
    private final MoviesRestClient moviesRestClient;

    public RecommandationService(UserRestClient userRestClient, MoviesRestClient moviesRestClient) {
        this.userRestClient = userRestClient;
        this.moviesRestClient = moviesRestClient;
    }

    public List<Film> addRecommandation(){


   return moviesRestClient.getFilms();
    }

    public User getUser(String userId){
        return userRestClient.getUser(userId);
    }
    public List<Film> getFilmsByGenre(String userId){
        String keyword=this.getUserPreferences(userId);
        if(keyword!=null) {
            return moviesRestClient.getFilmsByGenre(keyword);
        }
        else{
            return moviesRestClient.getFilmsByGenre("");
        }
    }
    public String getUserPreferences(String userId){
        User user=this.getUser(userId);
        if(user.getPreferences().isEmpty())
        	return "";
        return user.getPreferences().get(0);
    }
}
