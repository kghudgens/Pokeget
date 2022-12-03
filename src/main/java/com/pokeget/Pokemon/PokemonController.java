package com.pokeget.Pokemon;

import com.pokeget.exception.PokemonNotFoundException;
import com.pokeget.service.PokemonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;
import java.util.Objects;

/**
 *  Class represents the main access point for the application.
 */
@RestController
@RequestMapping("/pokemon")
public class PokemonController{

    @Inject
    private PokemonEntity pokemonEntity;

    @Inject
    private PokemonService pokemonService;


    /**
     * Method returns all pokemon objects stored in the Mongo DB instance
     *
     * @return a list of all pokemon objects
     */
    @GetMapping
    public ResponseEntity<List<PokemonEntity>> getAll(){
        return new ResponseEntity<List<PokemonEntity>>(pokemonService.getAll(), HttpStatus.OK);
    }


    /**
     * Method takes in a String id to return the pokemon object with the corresponding object
     *
     * @param id String that represents the entry number on the object
     * @return the pokemon object that matches the id parameter or and Not Found status
     */
    @GetMapping("/id/{id}")
    public ResponseEntity<PokemonEntity> getById(@PathVariable String id){
        if (Objects.isNull(pokemonService.getPokemonByMongoID(id))){
            //! currently returning 500, correct it to return 404
            throw new PokemonNotFoundException("Pokemon Not Found");
        }
            return new ResponseEntity<PokemonEntity>(pokemonService.getPokemonByMongoID(id), HttpStatus.OK);
    }


    /**
     * Get Mapping that gives client access to pokemon object through name parameter
     *
     * @param name client side request
     * @return list of pokemon with the requested pokedexID
     */
    @GetMapping(value = "/name/{name}")
    public ResponseEntity<PokemonEntity> getPokemon(@PathVariable("name") String name){
        if(pokemonService.findPokemonByName(name) == null){
            throw new PokemonNotFoundException("Pokemon Not Found");
        }
        return new ResponseEntity<PokemonEntity>(pokemonService.findPokemonByName(name), HttpStatus.OK);
    }


    /**
     * Get Mapping that gives client access to pokemon object through Pokedex ID parameter
     *
     * @param pokedexID client side request
     * @return list of pokemon with the requested pokedexID
     */
    @GetMapping(value = "/pokedexID/{pokedexID}")
    public List<PokemonEntity> getPokemonByID(@PathVariable int pokedexID){
        if (pokemonService.getPokemonByID(pokedexID) == null){
            throw new PokemonNotFoundException("Pokemon Not Found");
        }
        return pokemonService.getPokemonByID(pokedexID);
    }


    /**
     * Get Mapping that gives client access to pokemon object through type parameter
     *
     * @param type client side request
     * @return list of pokemon with the requested type
     */
    @GetMapping("/type/{type}")
    public List<PokemonEntity> getPokemonByType(@PathVariable String type){
        if (pokemonService.getPokemonByType(type)==null){
            throw new PokemonNotFoundException("Pokemon not found");
        }
        return pokemonService.getPokemonByType(type);
    }


    /**
     * Get Mapping that gives client access to pokemon object through ability parameter
     *
     * @param ability client side request
     * @return list of pokemon with the requested ability
     */
    @GetMapping("/ability/{ability}")
    public List<PokemonEntity> getPokemonByAbility(@PathVariable String ability){
        if(pokemonService.getPokemonByAbility(ability)==null){
            throw new PokemonNotFoundException("Pokemon not found");
        }
        return pokemonService.getPokemonByAbility(ability);
    }


    /**
     * Method allows client side to create new pokemon resource
     *
     * @param pokemonEntity object to be created
     * @return http response for if the object is created or not
     */
    @PostMapping("/")
    public ResponseEntity<PokemonEntity> addPokemon(@RequestBody PokemonEntity pokemonEntity){
        return new ResponseEntity<PokemonEntity>(pokemonService.addPokemon(pokemonEntity), HttpStatus.CREATED);
    }


    /**
     * Method uses a put mapping to update the targeted resource or creates the resource if it
     * doesnt exist already
     *
     * @param newPokemonEntity object to be created or updated
     * @return object affected by the request
     */
    @PutMapping("/{id}")
    public PokemonEntity updatePokemon(@RequestBody PokemonEntity newPokemonEntity, @PathVariable String id)
    {
        PokemonEntity calledToBeUpdated = pokemonService.getPokemonByMongoID(id);

        if(calledToBeUpdated == null){
            return pokemonService.addPokemon(newPokemonEntity);
        } else {
            calledToBeUpdated.setId(id);
            calledToBeUpdated.setName(newPokemonEntity.getName());
            calledToBeUpdated.setAbility(newPokemonEntity.getAbility());
            calledToBeUpdated.setType1(newPokemonEntity.getType1());
            calledToBeUpdated.setType2(newPokemonEntity.getType2());
            calledToBeUpdated.setHeight(newPokemonEntity.getHeight());
            calledToBeUpdated.setWeight(newPokemonEntity.getWeight());
            calledToBeUpdated.setPokedexID(newPokemonEntity.getPokedexID());
        }
        return pokemonService.addPokemon(calledToBeUpdated);
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

