package com.amine.moviesms.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.amine.moviesms.Entities.Comment;

public interface CommentRepository extends MongoRepository<Comment,String> {
}
