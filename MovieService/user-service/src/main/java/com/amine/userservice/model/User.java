package com.amine.userservice.model;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.management.relation.Role;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
@Document("users")
public class User {
	@Id
	private String id;
	private String username;
	private String password;
	private String email;
	private List<String> preferences;
	@CreatedDate
    private Date createdAt;
	private List<String> roles;

    // ...

    public List<SimpleGrantedAuthority> getAuthorities() {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role))
                .collect(Collectors.toList());
    }
    
    
    public static String toSt(User user) {
    	return user.getUsername()+"/"+user.getPassword()+"/"+user.getEmail()+"/"+user.getPreferences().get(0)+"/"+user.getRoles();
    }
	

}