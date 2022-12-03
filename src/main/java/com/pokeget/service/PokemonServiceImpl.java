package com.pokeget.service;

import com.pokeget.Pokemon.Pokemon;
import com.pokeget.Pokemon.PokemonRepository;

import javax.inject.Inject;
import java.util.List;

public class PokemonServiceImpl implements PokemonService {

    @Inject
    private final PokemonRepository pokemonRepository;

    public PokemonServiceImpl(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    @Override
    public List<Pokemon> getAll() {
        return pokemonRepository.findAll();
    }

    @Override
    public Pokemon addPokemon(Pokemon pokemon) {
        // insert create new resource
        return pokemonRepository.insert(pokemon);
    }

    @Override
    public List<Pokemon> findPokemonByName(String name) {
        return pokemonRepository.findPokemonByName(name);
    }

    @Override
    public Pokemon updatePokemon(Pokemon pokemon) {
        // save method overwrites the resource
        return pokemonRepository.save(pokemon);
    }

    @Override
    public void deletePokemonByID(String id) {
        pokemonRepository.deleteById(id);
    }

    @Override
    public List<Pokemon> getPokemonByID(int pokedexID) {
        return pokemonRepository.findByPokeDexID(pokedexID);
    }

    @Override
    public List<Pokemon> getPokemonByType(String type) {
        return pokemonRepository.findByPokemonType(type);
    }

    @Override
    public List<Pokemon> getPokemonByAbility(String ability) {
        return pokemonRepository.findByAbility(ability);
    }

    @Override
    public Pokemon getPokemonByMongoID(String id) {
        return pokemonRepository.findByPokemonID(id);

    }
}
