package com.pokeget.controller;

import com.pokeget.entity.Pokemon;
import com.pokeget.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pokemon/pokedexID")
public class PokemonPokedexIDController {

    @Autowired
    private PokemonService pokemonService;

    @GetMapping(value = "{pokedexID}")
    public List<Pokemon> getPokemonByID(@PathVariable int pokedexID){
        return pokemonService.getPokemonByID(pokedexID);
    }
}
