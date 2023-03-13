package com.example.phillipscelinaintegradorback;

import com.example.phillipscelinaintegradorback.bd.BD;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PhillipsCelinaIntegradorBackApplication {

	public static void main(String[] args) {
		BD.crearTablas();
		SpringApplication.run(PhillipsCelinaIntegradorBackApplication.class, args);
	}

}
