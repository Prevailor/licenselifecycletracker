package com.training.licenselifecycletracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;

@SpringBootApplication
@EnableWebSocketMessageBroker
public class LicenselifecycletrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LicenselifecycletrackerApplication.class, args);
	}

	
	
}
