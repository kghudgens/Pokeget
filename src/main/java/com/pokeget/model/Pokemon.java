package com.pokeget.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("pokemon")
public class Pokemon {

    @Id
    private String id;

    private String name;
    private String[] type;
    private String ability;
    private int height;
    private int weight;
    private int pokedexID;


    public Pokemon(String id, String name, String[] type, String ability, int height, int weight, int pokedexID) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.ability = ability;
        this.height = height;
        this.weight = weight;
        this.pokedexID = pokedexID;
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

    public String[] getType() {
        return type;
    }

    public void setType(String[] type) {
        this.type = type;
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
