package com.pokeget;

import com.pokeget.Pokemon.PokemonEntity;
import com.pokeget.Pokemon.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
@ComponentScan({"com.pokeget.pokemon"})
public class PokegetApplication implements CommandLineRunner {

	// autowired the repository so spring boot can find it automatically
	@Autowired
	PokemonRepository pokemonRepository;

	public static void main(String[] args) {
		SpringApplication.run(PokegetApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{

		// Data for commandlinerunner to insert into the mongorepository
//	List<Pokemon> listOfPokemon = new ArrayList<>();

	PokemonEntity p1  = new PokemonEntity("1", "Blastoise", "Water", "", "Torrent",  63,
			188, 9);
	PokemonEntity p2  = new PokemonEntity("2", "Charizard", "Fire", "Flying", "Blaze",  67,
				200, 6);
	PokemonEntity p3  = new PokemonEntity("3", "Blaziken", "Fire", "Fighting", "Speed Boost",  75,
				115, 257);
	PokemonEntity p4  = new PokemonEntity("4", "Sceptile", "Grass", "", "Overgrow",  63,
				115, 254);
	PokemonEntity p5  = new PokemonEntity("5", "Swampert", "Water", "Ground", "Torrent",  59,
				180, 260);
	PokemonEntity p6  = new PokemonEntity("6", "Empoleon", "Water", "Steel", "Defiant",  67,
				186, 395);
	PokemonEntity p7  = new PokemonEntity("7", "Serperior", "Grass", "", "Contrary",  130,
				138, 497);
	PokemonEntity p8  = new PokemonEntity("8", "Gengar", "Ghost", "Posion", "Cursed Body",  59,
				89, 94);
	PokemonEntity p9  = new PokemonEntity("9", "Alakazam", "Psychic", "", "Inner Focus",  59,
				106, 65);
	PokemonEntity p10  = new PokemonEntity("10", "Tyranitar", "Dark", "Rock", "Sand Stream",  79,445
				, 248);

	pokemonRepository.save(p1);
	pokemonRepository.save(p2);
	pokemonRepository.save(p3);
	pokemonRepository.save(p4);
	pokemonRepository.save(p5);
	pokemonRepository.save(p6);
	pokemonRepository.save(p7);
	pokemonRepository.save(p8);
	pokemonRepository.save(p9);
	pokemonRepository.save(p10);
	}
}
