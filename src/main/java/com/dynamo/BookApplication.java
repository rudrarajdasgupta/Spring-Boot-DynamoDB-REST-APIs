package com.dynamo;

import com.dynamo.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookApplication{

	public static void main(String[] args) {
		SpringApplication.run(BookApplication.class, args);
	}

}
