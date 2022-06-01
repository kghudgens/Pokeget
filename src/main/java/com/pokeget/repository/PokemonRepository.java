package com.pokeget.repository;

import com.pokeget.model.Pokemon;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PokemonRepository extends MongoRepository<Pokemon, String> {

    /**
     * Retrieves the pokemon object by name
     *
     * @param name name of the object
     * @return list of the pokemon
     */
    @Query("{'name' :?0}")
    List<Pokemon> findPokemonByName(String name);

    @Query("{'pokedexID' :?0 }")
    List<Pokemon> findByPokeDexID(int pokedexID);

    @Query(" '$or' : {'type1' : ?0} {'type2' : ?0}")
    List<Pokemon> findByPokemonType(String type);
}
