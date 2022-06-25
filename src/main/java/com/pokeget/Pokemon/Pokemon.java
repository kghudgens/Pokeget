package com.pokeget.Pokemon;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Component
@Document("pokemon")
public class Pokemon {

    @Id
    @NotNull
    @Size(min = 1)
    private String id;

    @NotNull(message = "Pokemon name is required")
    @Size(min=3, max = 10, message = "Pokemon name cannot be longer than 10 characters")
    private String name;

    @NotNull(message = "Pokemon type is required")
    @Size(min = 1)
    private String type1;

    @Size(min = 1)
    private String type2;

    @NotNull(message = "Pokemon ability is required")
    @Size(min = 1)
    private String ability;

    @PositiveOrZero
    private int height;

    @PositiveOrZero
    private int weight;

    @NotNull(message = "Pokemon pokedexId is required")
    @PositiveOrZero
    private int pokedexID;


    public Pokemon(String id, String name, String type1, String type2, String ability, int height, int weight, int pokedexID) {
        this.id = id;
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.ability = ability;
        this.height = height;
        this.weight = weight;
        this.pokedexID = pokedexID;
    }

    public Pokemon(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType1() {
        return type1;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }


    public int getPokedexID() {
        return pokedexID;
    }

    public void setPokedexID(int pokedexID) {
        this.pokedexID = pokedexID;
    }
}
