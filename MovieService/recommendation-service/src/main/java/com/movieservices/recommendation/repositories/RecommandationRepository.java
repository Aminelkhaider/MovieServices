package com.movieservices.recommendation.repositories;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.movieservices.recommendation.entities.Recommandation;

@Repository
public interface RecommandationRepository extends MongoRepository<Recommandation, String> {

}
