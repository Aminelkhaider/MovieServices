package com.amine.moviesms.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.amine.moviesms.Entities.Serie;

public interface SerieRepository  extends MongoRepository<Serie,String> {
}
