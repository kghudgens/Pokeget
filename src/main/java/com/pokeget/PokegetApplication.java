package com.pokeget;

import com.pokeget.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class PokegetApplication {

	// autowired the repository so spring boot can find it automatically
	@Autowired
	PokemonRepository pokemonRepository;

	public static void main(String[] args) {
		SpringApplication.run(PokegetApplication.class, args);
	}

}
