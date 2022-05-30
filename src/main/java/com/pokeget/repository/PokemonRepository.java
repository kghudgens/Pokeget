package com.pokeget.repository;

import com.pokeget.model.Pokemon;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PokemonRepository extends MongoRepository<Pokemon, String> {

    @Query("{name:'!0'}")
    Pokemon findPokemonByName(String name);





}
