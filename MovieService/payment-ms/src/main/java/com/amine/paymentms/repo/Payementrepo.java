package com.amine.paymentms.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.amine.paymentms.Client.StripeClient;

public interface Payementrepo extends  MongoRepository<StripeClient, String>{

}


