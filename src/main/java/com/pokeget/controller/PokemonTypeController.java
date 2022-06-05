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
 * Class represents the clients access to the pokemon object through the "type" parameter
 */
@RestController
@RequestMapping("/pokemon/type")
public class PokemonTypeController {

    // Access the service layer
    @Autowired
    private PokemonService pokemonService;

    /**
     * Get Mapping that gives client access to pokemon object through type parameter
     *
     * @param type client side request
     * @return list of pokemon with the requested type
     */
    @GetMapping("/{type}")
    public List<Pokemon> getPokemonByType(@PathVariable String type){
        return pokemonService.getPokemonByType(type);
    }

}
