package com.pokeget.Pokemon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/**
 *  Class represents the main access point for the application.
 */
@RestController
@RequestMapping("/pokemon")
public class PokemonController{

    @Autowired
    private Pokemon pokemon;

    // access to the service layer
    @Autowired
    private PokemonService pokemonService;

    /**
     * Method returns all pokemon objects stored in the Mongo DB instance
     *
     * @return a list of all pokemon objects
     */
    @GetMapping
    public List<Pokemon> getAll(){
        return pokemonService.getAll();
    }

    /**
     * Method takes in a String id to return the pokemon object with the corresponding object
     *
     * @param id String that represents the entry number on the object
     * @return the pokemon object that matches the id parameter or and Not Found status
     */
    @GetMapping("/{id}")
    public Pokemon getById(@PathVariable String id){
        try{
            return pokemonService.getPokemonByMongoID(id);
        } catch(Exception exc){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Pokemon Not Found", exc
            );
        }

    }

    /**
     * Get Mapping that gives client access to pokemon object through name parameter
     *
     * @param name client side request
     * @return list of pokemon with the requested pokedexID
     */
    @GetMapping(value = "/name/{name}")
    public List<Pokemon> getPokemon(@PathVariable("name") String name){
        return pokemonService.findPokemonByName(name);
    }

    /**
     * Get Mapping that gives client access to pokemon object through Pokedex ID parameter
     *
     * @param pokedexID client side request
     * @return list of pokemon with the requested pokedexID
     */
    @GetMapping(value = "/pokedexID/{pokedexID}")
    public List<Pokemon> getPokemonByID(@PathVariable int pokedexID){
        return pokemonService.getPokemonByID(pokedexID);
    }

    /**
     * Get Mapping that gives client access to pokemon object through type parameter
     *
     * @param type client side request
     * @return list of pokemon with the requested type
     */
    @GetMapping("/type/{type}")
    public List<Pokemon> getPokemonByType(@PathVariable String type){
        return pokemonService.getPokemonByType(type);
    }


    /**
     * Get Mapping that gives client access to pokemon object through ability parameter
     *
     * @param ability client side request
     * @return list of pokemon with the requested ability
     */
    @GetMapping("/ability/{ability}")
    public List<Pokemon> getPokemonByAbility(@PathVariable String ability){
        return pokemonService.getPokemonByAbility(ability);
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
//    @PutMapping("/{id}")
//    public Pokemon updatePokemon(@RequestBody Pokemon newPokemon, @PathVariable String id)
//    {
//        Pokemon calledToBeUpdated = pokemonService.getPokemonByMongoID(id);
//
//     return pokemonService.getPokemonByMongoID(id)
//             .map(pokemon ->{
//
//                     }
//     );
//    }

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

