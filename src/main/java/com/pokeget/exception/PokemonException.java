package com.pokeget.exception;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

/**
 * Class represents the payload returned when an exception is raised. With the message describing why, the exception
 * thrown, applicable HTTP status, and timestamp of the response.
 */
public class PokemonException {
    private final String message;
    private final Throwable throwable;
    private final HttpStatus httpStatus;
    private final ZonedDateTime timeStamp;

    public PokemonException(String message, Throwable throwable, HttpStatus httpStatus, ZonedDateTime timeStamp) {
        this.message = message;
        this.throwable = throwable;
        this.httpStatus = httpStatus;
        this.timeStamp = timeStamp;
    }

}
