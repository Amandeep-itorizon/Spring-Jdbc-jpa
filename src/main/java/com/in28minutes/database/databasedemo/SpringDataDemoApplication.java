package com.in28minutes.database.databasedemo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.in28minutes.database.databasedemo.jdbc.Person;
import com.in28minutes.database.databasedemo.springdata.PersonSpringDataRepository;

@SpringBootApplication
public class SpringDataDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonSpringDataRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		logger.info("User id 10001 -> {}", repository.findById(10001));

		logger.info("Inserting -> {}", repository.save(new Person("Tara", "Berlin", new Date())));
		logger.info("Update 2 -> {}", repository.save(new Person(2, "Brain", "Aus", new Date())));
		logger.info("User id 1 -> {}", repository.findById(1));

		repository.deleteById(1);

		logger.info("All users -> {}", repository.findAll());

//		logger.info("All users -> {}", dao.findAll());
//		logger.info("Deleting id 10002 -> {}", dao.deleteById(10001));

	}

}
