package com.movieservices.recommendation.openfeign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.movieservices.recommendation.models.User;

import java.util.List;

@FeignClient(name= "user-service")
public interface UserRestClient {
    @GetMapping("/users")
    List<User>  getUsers();
    @GetMapping("/users/{id}")
    User getUser(@PathVariable("id") String userId);
}
