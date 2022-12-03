package com.pokeget.service;

import com.pokeget.Pokemon.PokemonEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PokemonService {

    List<PokemonEntity> getAll();

    PokemonEntity addPokemon(PokemonEntity pokemonEntity);

    PokemonEntity findPokemonByName(String name);

    PokemonEntity updatePokemon(PokemonEntity pokemonEntity);

    void deletePokemonByID(String id);

    PokemonEntity getPokemonByID(int pokedexID);

    List<PokemonEntity> getPokemonByType(String type);

    List<PokemonEntity> getPokemonByAbility(String ability);

    PokemonEntity getPokemonByMongoID(String id);
}
