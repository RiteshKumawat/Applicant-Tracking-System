package com.ats;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class AtsApplication {

	public static void main(String[] args) {
		System.out.println("HELOO ATS");
		SpringApplication.run(AtsApplication.class, args);
	}

}
