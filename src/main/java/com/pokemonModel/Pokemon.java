package com.pokemonModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.util.Objects;

@Entity
public class Pokemon {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int pokedexEntry;
    private String type1;
    private String type2;

    public Pokemon() {
    }

    public Pokemon(Long id, String name, int pokedexEntry, String type1, String type2) {
        this.id = id;
        this.name = name;
        this.pokedexEntry = pokedexEntry;
        this.type1 = type1;
        this.type2 = type2;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPokedexEntry() {
        return this.pokedexEntry;
    }

    public void setPokedexEntry(int pokedexEntry) {
        this.pokedexEntry = pokedexEntry;
    }

    public String getType1() {
        return this.type1;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public String getType2() {
        return this.type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    public Pokemon id(Long id) {
        setId(id);
        return this;
    }

    public Pokemon name(String name) {
        setName(name);
        return this;
    }

    public Pokemon pokedexEntry(int pokedexEntry) {
        setPokedexEntry(pokedexEntry);
        return this;
    }

    public Pokemon type1(String type1) {
        setType1(type1);
        return this;
    }

    public Pokemon type2(String type2) {
        setType2(type2);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Pokemon)) {
            return false;
        }
        Pokemon pokemon = (Pokemon) o;
        return Objects.equals(id, pokemon.id) && Objects.equals(name, pokemon.name)
                && pokedexEntry == pokemon.pokedexEntry && Objects.equals(type1, pokemon.type1)
                && Objects.equals(type2, pokemon.type2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, pokedexEntry, type1, type2);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", name='" + getName() + "'" +
                ", pokedexEntry='" + getPokedexEntry() + "'" +
                ", type1='" + getType1() + "'" +
                ", type2='" + getType2() + "'" +
                "}";
    }

}
