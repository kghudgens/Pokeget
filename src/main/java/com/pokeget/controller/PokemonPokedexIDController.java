package com.pokeget.controller;

import com.pokeget.entity.Pokemon;
import com.pokeget.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Class represents the clients access to the pokemon object through the "Pokedex ID" parameter
 */
@RestController
@RequestMapping("/pokemon/pokedexID")
public class PokemonPokedexIDController {

    // Access to the service layer
    @Autowired
    private PokemonService pokemonService;

    /**
     * Get Mapping that gives client access to pokemon object through Pokedex ID parameter
     *
     * @param pokedexID client side request
     * @return list of pokemon with the requested pokedexID
     */
    @GetMapping(value = "{pokedexID}")
    public List<Pokemon> getPokemonByID(@PathVariable int pokedexID){
        return pokemonService.getPokemonByID(pokedexID);
    }
}
