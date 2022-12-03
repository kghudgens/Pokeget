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


    @GetMapping
    public ResponseEntity<List<PokemonEntity>> getAllPokemon(){
        return new ResponseEntity<List<PokemonEntity>>(pokemonService.getAll(), HttpStatus.OK);
    }



    @GetMapping("/id/{id}")
    public ResponseEntity<PokemonEntity> getByPokemonPokedexId(@PathVariable int id){
        if (Objects.isNull(pokemonService.getPokemonByID(id))){
            throw new PokemonNotFoundException("Pokemon Not Found");
        }
            return new ResponseEntity<PokemonEntity>(pokemonService.getPokemonByID(id), HttpStatus.OK);
    }


    @GetMapping(value = "/name/{name}")
    public ResponseEntity<PokemonEntity> getPokemonByName(@PathVariable("name") String name){
        if(pokemonService.getPokemonByName(name) == null){
            throw new PokemonNotFoundException("Pokemon Not Found");
        }
        return new ResponseEntity<PokemonEntity>(pokemonService.getPokemonByName(name), HttpStatus.OK);
    }


    @GetMapping("/type/{type}")
    public List<PokemonEntity> getPokemonByType(@PathVariable String type){
        if (Objects.isNull(pokemonService.getPokemonByType(type))) {
            throw new PokemonNotFoundException("Pokemon not found");
        }
        return pokemonService.getPokemonByType(type);
    }


    @GetMapping("/ability/{ability}")
    public List<PokemonEntity> getPokemonByAbility(@PathVariable String ability){
        if(Objects.isNull(pokemonService.getPokemonByAbility(ability))){
            throw new PokemonNotFoundException("Pokemon not found");
        }
        return pokemonService.getPokemonByAbility(ability);
    }


    @PostMapping("/")
    public ResponseEntity<PokemonEntity> addPokemon(@RequestBody PokemonEntity pokemonEntity){
        return new ResponseEntity<PokemonEntity>(pokemonService.addPokemon(pokemonEntity), HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public PokemonEntity updatePokemon(@RequestBody PokemonEntity newPokemonEntity, @PathVariable String id)
    {
        PokemonEntity calledToBeUpdated = pokemonService.getPokemonByName(newPokemonEntity.getName());

        if (Objects.isNull(calledToBeUpdated)) {
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


    @DeleteMapping("/{id}")
    public void deletePokemon(@PathVariable("id") String id){
        pokemonService.deletePokemonByID(id);
    }

}

