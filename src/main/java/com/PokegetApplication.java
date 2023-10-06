package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.pokemonController.PokemonController;

@SpringBootApplication
@ComponentScan(basePackageClasses = PokemonController.class)
public class PokegetApplication {
	public static void main(String[] args) {

		SpringApplication.run(PokegetApplication.class, args);
	}

}
