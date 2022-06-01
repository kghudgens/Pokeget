package com.pokeget.pokemon;

import com.pokeget.model.Pokemon;
import com.pokeget.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.events.Event;

import java.util.List;

@Service
public class PokemonService {
    /**
     * Reference to the Pokemon Repository
     */
    @Autowired
    PokemonRepository pokemonRepository;

    /**
     * Constructor injected with the Pokemon Repository reference giving the Pokemon Service access to the interface and
     * Mongo Repository
     *
     * @param pokemonRepository Reference to the repository
     */
    public PokemonService(PokemonRepository pokemonRepository){
        this.pokemonRepository = pokemonRepository;
    }

    /**
     * Method that supports the controller get method by returning a list of all pokemon objects in the Pokemon Repository
     *
     * @return list of all pokemon objects in the database
     */
    public List<Pokemon> getAll() {
        return pokemonRepository.findAll();
    }

    /**
     * Method that supports the post mapping by letting the client insert into the Pokemon Repository
     *
     * @param pokemon object to be inserted into the repository
     * @return the object inserted into the repository
     */
    public Pokemon addPokemon(Pokemon pokemon){
        // insert create new resource
        return pokemonRepository.insert(pokemon);
    }

    // Docs located in interface
    public List<Pokemon> findPokemonByName(String name){
        return pokemonRepository.findPokemonByName(name);
    }

    /**
     * Updates the pokemon object
     *
     * @param pokemon object to be updated
     * @return updated object
     */
    public Pokemon updatePokemon(Pokemon pokemon) {
        // save method overwrites the resource
        return pokemonRepository.save(pokemon);
    }

    public void delete(String id) {
         pokemonRepository.deleteById(id);
    }

    public List<Pokemon> getPokemonByID(int pokedexID) {
        return pokemonRepository.findByPokeDexID(pokedexID);
    }

    public List<Pokemon> getPokemonByType(String type) {
        return pokemonRepository.findByPokemonType(type);
    }
}
