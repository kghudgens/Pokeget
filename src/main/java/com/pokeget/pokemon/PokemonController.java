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

    @GetMapping
    public List<Pokemon> getAll(){
        return pokemonService.getAll();
    }

    @GetMapping("/{name}")
    public List<Pokemon> getPokemon(@PathVariable String name){
        return pokemonService.findPokemonByName(name);
    }

    @GetMapping("/{pokeid}")
    public List<Pokemon> getPokemonByID(@PathVariable int pokeid){
        return pokemonService.getPokemonByID(pokeid);
    }

    @GetMapping("/{type}")
    public List<Pokemon> getPokemonByType(@PathVariable String type){
        return pokemonService.getPokemonByType(type);
    }

    @PostMapping("/")
    public Pokemon addPokemon(@RequestBody Pokemon pokemon){
        return pokemonService.addPokemon(pokemon);
    }

    @PutMapping("/")
    public Pokemon updatePokemon(@RequestBody Pokemon pokemon) {
        return pokemonService.updatePokemon(pokemon);
    }

    @DeleteMapping("/{id}")
    public void deletePokemon(@RequestParam("id") String id){
        pokemonService.delete(id);
    }

}

