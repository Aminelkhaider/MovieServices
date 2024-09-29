package com.amine.userservice.controller;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.apache.commons.codec.binary.Hex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amine.userservice.config.IsAdmin;
import com.amine.userservice.model.AuthRequest;
import com.amine.userservice.model.User;
import com.amine.userservice.repository.UserRepository;
import com.amine.userservice.service.JwtService;
import com.amine.userservice.service.MyService;

import jakarta.annotation.security.RolesAllowed;




@RestController
@Component
public class UserController {
	
	private final UserRepository userRepository;
	
	
	@Autowired
	private JwtService jwtService;
	@Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private MyService myService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public UserController(UserRepository userRepository) {
		this.userRepository=userRepository;
	}
	
	
	@GetMapping("/users1")
	public ResponseEntity<List<String>> getEncodedPassword(){
		//String hex = Hex.encodeHexString(salt);
		//String hex1=Hex.encodeHexString(salt.toString().getBytes(StandardCharsets.UTF_8));
		//BytesEncryptor encryptor = new AesBytesEncryptor(hex,hex);
		List<User> users=this.userRepository.findAll();
		
		List<String> strings=new ArrayList();
		try {
			for(int i=0;i<users.size();i++) {
			String s=users.get(i).getPassword();
			strings.add(myService.decrypt(s));
		   
		}
		}
		catch(Exception e){
			System.out.println("wdvsf");
		}
		
		return ResponseEntity.ok(strings);
	}
	
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers(){
		return ResponseEntity.ok(this.userRepository.findAll());
		
	}
	
	
	@GetMapping("/users2")
	public ResponseEntity<List<User>> getAllUsers1(@RequestBody AuthRequest authRequest){
		return ResponseEntity.ok(this.userRepository.findAll());
		
	}
	
	
	
		
		
		
	
	@PostMapping("/register")
	
	public ResponseEntity<User> createUser(@RequestBody User user){
		try {
			user.setPassword(passwordEncoder.encode(user.getPassword())) ;
		}
		catch(Exception e){
			System.out.println("wdvsf");
		}
		
		//String hex = Hex.encodeHexString(secretKey.toString().getBytes(StandardCharsets.UTF_8));
		//String hex1=Hex.encodeHexString(salt.toString().getBytes(StandardCharsets.UTF_8));
		//String hex = Hex.encodeHexString(secretKey);
		//BytesEncryptor encryptor = new AesBytesEncryptor(hex,hex);
		
		return ResponseEntity.status(201).body(this.userRepository.save(user));
	}
	
	@PostMapping("/login")
	public String authentificateAndGetToken(@RequestBody AuthRequest authRequest) {
		 List<GrantedAuthority> authorities=new ArrayList<>();
		 authorities.add(new SimpleGrantedAuthority(userRepository.findByUsername(authRequest.getUsername()).get().getRoles().get(0)));
		Authentication authenticate= authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername() ,authRequest.getPassword(),authorities));
		if(authenticate.isAuthenticated()) {
			return jwtService.generateToken(authRequest.getUsername());
		}
		else {
			throw new RuntimeException("invalid access");
		}
		
	}
	
	@GetMapping("/validate")
	public ResponseEntity<String> ValidateToken(@RequestHeader String token){
		try {
			jwtService.validateToken(token);
		}
		catch(Exception e) {
			return ResponseEntity.status(500).body("Token is invalid");
		}
		
		return ResponseEntity.status(200).body("Token is valid");
	}
	
	@GetMapping("/validate1")
	public ResponseEntity<String> ValidateToken1(@RequestParam String token){
		try {
			jwtService.validateToken(token);
		}
		catch(Exception e) {
			return ResponseEntity.status(500).body("Token is invalid");
		}
		
		return ResponseEntity.status(200).body("Token is valid");
	}
	@GetMapping("/users/{id}")
	public Optional<User> getUserById(@PathVariable("id") String userID){
	return userRepository.findById(userID);


	}
	
	@PostMapping("/abonnement")
	public ResponseEntity<String> PAYEMENT(@RequestBody User user,String data){
		kafkaTemplate.send("payement1",User.toSt(user));
		return ResponseEntity.status(200).body("operation en cours du traitemant");
	}


}
