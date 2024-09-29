package com.amine.userservice.service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtService {
	
	public String generateToken(String username) {
		Map<String , Object> claims =new HashMap();
		return createToken(claims,username);
		
	}

	private String createToken(Map<String, Object> claims, String username) {
		// TODO Auto-generated method stub
		return Jwts.builder()
				.setClaims(claims)
				.setSubject(username)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+1000*60*30))
				.signWith(getSignKey(),SignatureAlgorithm.HS256).compact()
				;
	}

	private Key getSignKey() {
		byte[] keyBytes=Decoders.BASE64.decode("556A576E5A7234753778214125442A472D4B6150645367566B59703273357638");
		return Keys.hmacShaKeyFor(keyBytes);
	}
	
	public void validateToken(String token) {
			Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token);
		
		
	}

}
