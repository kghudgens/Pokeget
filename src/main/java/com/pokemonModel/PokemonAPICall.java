package com.pokemonModel;

public class PokemonAPICall {

    private static PokemonAPICall single_instance = null;
    private final PokemonRepository repository;

    private PokemonAPICall() {
        // intentionally blank
    }

    public static PokemonAPICall getInstance() {
        if (single_instance == null) {
            single_instance = new PokemonAPICall();
        }
        return single_instance;
    }

    public void checkDB(String name) {
        Pokemon returnedPokemon = repository.findByPokemonName(name);
        if (returnedPokemon == nul) {
            // Make the api call with the pokemon
            // Save the important pieces
            // Send it to the database
            // Create object with it and send it to teh controller

        }
    }
}