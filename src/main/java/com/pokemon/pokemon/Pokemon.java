package com.pokemon.pokemon;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;

/*
 *The Pokemon class represents the data that will be taken for each pokemon query.
 *
 * @author Kevin Hudgens
 * @version 1.0
 */


public class Pokemon{
    // attributes defining the pokedmon
    @Id
    private long id;
    private Integer pokedexEntry;
    private String name;
    private Integer height;
    private Integer weight;
    private int[] types = new int[2];

    public Pokemon(){

    }


    /*
    * The Pokemon constructor instantiates its class with all fields execept the id field because the
    * field is not assigned until.
    *
    * @param pokedexEntry Integer of the pokemon's pokedex entry number
    * @param name String of the pokemons name
    * @param height Integer of the pokemons height
    * @param weight Integer of the pokemons weight
    * @ArrayList types an ArrayList
    */
    public Pokemon(Integer pokedexEntry, String name, Integer height, Integer weight, int[] types) {
        this.pokedexEntry = pokedexEntry;
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.types = types;
    }

    /*
     * The Pokemon constructor instantiates its class with all fields.
     *
     * @param id long of the pokemons id number in the MongoDB instance
     * @param pokedexEntry Integer of the pokemon's pokedex entry number
     * @param name String of the pokemons name
     * @param height Integer of the pokemons height
     * @param weight Integer of the pokemons weight
     * @ArrayList types an ArrayList
     */
    public Pokemon(long id, Integer pokedexEntry, String name, Integer height, Integer weight, int[] types) {
        this.id = id;
        this.pokedexEntry = pokedexEntry;
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.types = types;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getPokedexEntry() {
        return pokedexEntry;
    }

    public void setPokedexEntry(Integer pokedexEntry) {
        this.pokedexEntry = pokedexEntry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public int[] getTypes() {
        return types;
    }

    public void setTypes(int[] types) {
        this.types = types;
    }
}
