package com.in28minutes.database.databasedemo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import com.in28minutes.database.databasedemo.jdbc.Person;
import com.in28minutes.database.databasedemo.jpa.PersonJpaRepository;

//@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJpaRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		logger.info("User id 10001 -> {}", repository.findById(10001));

		logger.info("Inserting -> {}", repository.insert(new Person("Tara", "Berlin", new Date())));
		logger.info("Update 2 -> {}", repository.update(new Person(2, "Brain", "Aus", new Date())));
		logger.info("User id 1 -> {}", repository.findById(1));

		repository.deleteById(1);

		logger.info("All users -> {}", repository.findAll());

//		logger.info("All users -> {}", dao.findAll());
//		logger.info("Deleting id 10002 -> {}", dao.deleteById(10001));

	}

}
