package com.pokeget.service;

import com.pokeget.Pokemon.PokemonEntity;
import com.pokeget.Pokemon.PokemonRepository;

import javax.inject.Inject;
import java.util.List;

public class PokemonServiceImpl implements PokemonService {

    @Inject
    private final PokemonRepository pokemonRepository;

    @Inject
    private final PokemonEntity pokemonEntity;

    public PokemonServiceImpl(PokemonRepository pokemonRepository, PokemonEntity pokemonEntity) {
        this.pokemonRepository = pokemonRepository;
        this.pokemonEntity = pokemonEntity;
    }

    @Override
    public List<PokemonEntity> getAll() {
        return pokemonRepository.findAll();
    }

    @Override
    public PokemonEntity addPokemon(PokemonEntity pokemonEntity) {
        // insert create new resource
        return pokemonRepository.insert(pokemonEntity);
    }

    @Override
    public PokemonEntity getPokemonByName(String name) {
        return pokemonRepository.findPokemonByName(name);
    }

    @Override
    public PokemonEntity updatePokemon(PokemonEntity pokemonEntity) {
        return pokemonRepository.save(pokemonEntity);
    }

    @Override
    public void deletePokemonByID(String id) {
        pokemonRepository.deleteById(id);
    }

    @Override
    public PokemonEntity getPokemonByID(int pokedexID) {
        return pokemonRepository.findByPokeDexID(pokedexID);
    }

    @Override
    public List<PokemonEntity> getPokemonByType(String type) {
        return pokemonRepository.findByPokemonType(type);
    }

    @Override
    public List<PokemonEntity> getPokemonByAbility(String ability) {
        return pokemonRepository.findByAbility(ability);
    }

}
