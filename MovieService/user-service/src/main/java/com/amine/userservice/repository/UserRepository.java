package com.amine.userservice.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.amine.userservice.model.User;

public interface UserRepository extends MongoRepository<User, String>{

	Optional<User> findByUsername(String username);

}
