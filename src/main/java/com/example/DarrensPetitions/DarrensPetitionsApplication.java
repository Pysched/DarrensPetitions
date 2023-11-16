package com.example.DarrensPetitions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class DarrensPetitionsApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(DarrensPetitionsApplication.class);
		app.setDefaultProperties(Collections.singletonMap("server.port", "8087"));
		app.run(args);
	}

}
