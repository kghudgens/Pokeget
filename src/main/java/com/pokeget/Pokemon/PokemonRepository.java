package com.pokeget.Pokemon;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PokemonRepository extends MongoRepository<PokemonEntity, String> {

    @Query("{'name' :?0}")
    PokemonEntity findPokemonByName(String name);

    @Query("{'pokedexID' :?0 }")
    PokemonEntity findByPokeDexID(int pokedexID);

    @Query(" {'$or' : [{'type1' : ?0}, {'type2' : ?0}]}")
    List<PokemonEntity> findByPokemonType(String type);

    @Query("{'ability': ?0}")
    List<PokemonEntity> findByAbility(String ability);

    @Query("{'id': ?0}")
    PokemonEntity findByPokemonID(String id);

    @Query(value = "{'name' : ?0}", delete = true)
    PokemonEntity deleteByName(String name);

}
