package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

	private final SingerRepository repository;

	@Autowired
	public DatabaseLoader(SingerRepository repository) {
		this.repository = repository;
	}

	@Override
	public void run(String... strings) throws Exception {
		this.repository.save(new Singer("Chester", "Linkin Park", "Papercut"));
		this.repository.save(new Singer("Jonathan", "KoRn", "Thoughtless"));
		this.repository.save(new Singer("Corey", "Slipnot", "Duality"));

	}
}