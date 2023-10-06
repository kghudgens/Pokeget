package com.pokeget.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

/**
 * Class represents an exception handler when a Pokemon Object is not found in the database. It is marked with the
 * ControllerAdvice annotation that tells Spring that the class will be handling exceptions.
 */
@ControllerAdvice
public class PokemonExceptionHandler {

    /**
     * Method that handles the PokemonNotFoundException. Creating the payload to be shown to the user.
     *
     * @param e the instance of the pokemonNotFoundException
     * @return the payload with the defined responses and the appropriate HTTP status
     */
    @ExceptionHandler(value={PokemonNotFoundException.class})
    public ResponseEntity<Object> handlePokemonNotFoundException(PokemonNotFoundException e){
        // 1. Create payload containing exception
        PokemonException pokemonException = new PokemonException(
                // get message method is extended from the runtime exception the PokemonNotFoundException is extending
                e.getMessage(),
                e,
                HttpStatus.NOT_FOUND,
                ZonedDateTime.now()
        );
        // 2. Return response entity
        return new ResponseEntity<>(pokemonException, HttpStatus.NOT_FOUND);
    }
}
