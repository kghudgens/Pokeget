package com.pokemonModel;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

interface PokemonRepository extends JpaRepository<Pokemon, Long> {
    Pokemon findByPokemonName(String name);

    Pokemon findByPokedexEntry(int pokedexEntry);

    List<Pokemon> findByAllByType(String type);

}
