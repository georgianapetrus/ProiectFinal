package com.ausy_technologies_proiectfinal;

import com.ausy_technologies_proiectfinal.Error.ErrorResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProiectfinalApplication {

	public static void main(String[] args) {

		ErrorResponse.startLogger();
		SpringApplication.run(ProiectfinalApplication.class, args);
	}

}