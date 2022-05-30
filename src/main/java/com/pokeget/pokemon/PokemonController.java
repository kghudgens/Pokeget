package com.pokeget.pokemon;

import com.pokeget.model.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {
    @Autowired
    PokemonService pokemonService;

    @GetMapping("/")
    public List<Pokemon> getAll(){
        return pokemonService.getAll();
    }

    @PostMapping("/")
    public Pokemon addPokemon(@RequestBody Pokemon pokemon){
        return pokemonService.addPokemon(pokemon);
    }
}

