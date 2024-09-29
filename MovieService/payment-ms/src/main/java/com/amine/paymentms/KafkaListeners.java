package com.amine.paymentms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.amine.paymentms.Controller.PaymentGatewayController;



@Component
public class KafkaListeners {
	
	@Autowired
	private PaymentGatewayController controller;
	
	@Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
	
	@KafkaListener(
			topics="payement1",
			groupId= "groupId"
			)
	void listener(String data) {
		
		System.out.println("Listner received: " + data);
		
		controller.PAYEMENT(data);
		
		
		
		
		
	}
	
	
}