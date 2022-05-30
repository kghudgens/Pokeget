package com.pokeget.pokemon;

import com.pokeget.model.Pokemon;
import com.pokeget.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonService {
    @Autowired
    PokemonRepository pokemonRepository;

    public PokemonService(PokemonRepository pokemonRepository){
        this.pokemonRepository = pokemonRepository;
    }

    public List<Pokemon> getAll() {
        return pokemonRepository.findAll();
    }

    public Pokemon addPokemon(Pokemon pokemon){
        return pokemonRepository.insert(pokemon);
    }
}
