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
 * Class represents the clients access to the pokemon object through the "ability" parameter
 */
@RestController
@RequestMapping("/pokemon/ability")
public class PokemonAbilityController {

    @Autowired
    private PokemonService pokemonService;

    /**
     * Get Mapping that gives client access to pokemon object through ability parameter
     *
     * @param ability client side request
     * @return list of pokemon with the requested ability
     */
    @GetMapping("/{ability}")
    public List<Pokemon> getPokemonByAbility(@PathVariable String ability){
        return pokemonService.getPokemonByAbility(ability);
    }

}
