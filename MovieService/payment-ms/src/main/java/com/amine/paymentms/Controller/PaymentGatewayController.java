package com.amine.paymentms.Controller;


import com.amine.paymentms.Client.StripeClient;
import com.amine.paymentms.repo.Payementrepo;
import com.stripe.model.Charge;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
@RestController
public class PaymentGatewayController {
	
	@Autowired
	private Payementrepo payementrepo;
	
	@Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
	
	@PutMapping("/charge")
	public String PAYEMENT(@RequestBody String id){
		System.out.println(id);
		List<StripeClient> list=payementrepo.findAll();
		String s=id.split("/")[0];
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getUsername().equals(s)) {
				if(list.get(i).getSolde()<100) {
					
					kafkaTemplate.send("payement2","non");return "non";
				}
				list.get(i).setSolde(list.get(i).getSolde()-100);
				payementrepo.save(list.get(i));
			}
		}
		System.out.println(id);
		kafkaTemplate.send("payement2",id);
		
		return "oui";
	}
	
	@PostMapping("/add")
	public String add(@RequestBody StripeClient pay) {
		payementrepo.save(pay);
		return "valid";
	}
	@GetMapping("/payements")
	public List<StripeClient> a() {
		return payementrepo.findAll();
	}


    
}