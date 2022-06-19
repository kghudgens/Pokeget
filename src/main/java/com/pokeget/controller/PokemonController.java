package com.pokeget.controller;

import com.pokeget.entity.Pokemon;
import com.pokeget.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *  Class represents the main access point for the application.
 */
@RestController
@RequestMapping("/pokemon")
public class PokemonController{

    // access to the service layer
    @Autowired
    private PokemonService pokemonService;

    @GetMapping
    public List<Pokemon> getAll(){
        return pokemonService.getAll();
    }

    @GetMapping("/{id}")
    public Pokemon getById(@PathVariable String id){
        return pokemonService.getPokemonByMongoID(id);
    }


    /**
     * Method allows client side to create new pokemon resource
     *
     * @param pokemon object to be created
     * @return http response for if the object is created or not
     */
    @PostMapping("/")
    public ResponseEntity<Pokemon> addPokemon(@RequestBody Pokemon pokemon){
        return new ResponseEntity<Pokemon>(pokemonService.addPokemon(pokemon), HttpStatus.CREATED);
    }

    /**
     * Method uses a put mapping to update the targeted resource or creates the resource if it
     * doesnt exist already
     *
     * @param pokemon object to be created or updated
     * @return object affected by the request
     */
    @PutMapping("/")
    public Pokemon updatePokemon(@RequestBody Pokemon pokemon) {
        return pokemonService.updatePokemon(pokemon);
    }

    /**
     * Method deletes the resource matching the id parameter
     *
     * @param id id of the resource to be deleted
     */
    @DeleteMapping("/{id}")
    public void deletePokemon(@PathVariable("id") String id){
        pokemonService.deletePokemonByID(id);
    }

}

