package com.amine.paymentms.Client;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
@Document("payememt")
public class StripeClient {
	@Id
	private String id;
	private String username;
	private double solde;
    
}