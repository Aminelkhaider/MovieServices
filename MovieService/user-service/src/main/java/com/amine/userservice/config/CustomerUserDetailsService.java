package com.amine.userservice.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.amine.userservice.model.User;
import com.amine.userservice.repository.UserRepository;

@Component
public class CustomerUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User>  credential=userRepository.findByUsername(username);
		return credential.map(CustomerUserDetails::new).orElseThrow(()-> new UsernameNotFoundException("user not found with name"+username));
	}

}
