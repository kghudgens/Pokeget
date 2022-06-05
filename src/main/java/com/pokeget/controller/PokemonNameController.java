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
 * Class represents the clients access to the pokemon object through the "name" parameter
 */
@RestController
@RequestMapping("pokemon/name/")
public class PokemonNameController {

    @Autowired
    private PokemonService pokemonService;

    /**
     * Get Mapping that gives client access to pokemon object through name parameter
     *
     * @param name client side request
     * @return list of pokemon with the requested pokedexID
     */
    @GetMapping(value = "/{name}")
    public List<Pokemon> getPokemon(@PathVariable("name") String name){
        return pokemonService.findPokemonByName(name);
    }
}
