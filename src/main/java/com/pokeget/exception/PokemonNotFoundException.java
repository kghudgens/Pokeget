package com.pokeget.exception;

/**
 * Class represents the Pokemon Not Found Exception. Exception is raised when user queries the API with data not
 * currently in the database.
 */
public class PokemonNotFoundException extends RuntimeException {

    public PokemonNotFoundException(String message){
        super(message);
    }

    public PokemonNotFoundException(String message, Throwable cause){
        super(message, cause);
    }
}
