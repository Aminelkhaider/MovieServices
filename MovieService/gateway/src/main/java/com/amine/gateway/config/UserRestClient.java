package com.amine.gateway.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name= "user-service")
public interface UserRestClient {
	@GetMapping("/validate")
	public ResponseEntity<String> ValidateToken(@RequestHeader String token);
}
