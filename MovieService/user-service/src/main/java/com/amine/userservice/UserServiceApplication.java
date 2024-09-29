package com.amine.userservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.config.EnableMongoAuditing;



@SpringBootApplication
@EnableDiscoveryClient
@EnableMongoAuditing
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}
	/*
	@Bean
	CommandLineRunner commandLineRunner(KafkaTemplate<String, Notification> kafkaTemplate) {
		return args -> {
			Notification notif=notificationRepository.findAll().get(0);
			for(int i=0; i<20 ;i++) {
				kafkaTemplate.send("Notification",notif );
			}
		};
	}
*/
}
