package com.pokemon.pokemon;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// Need to use controller because thymeleaf does not support rest controller
@Controller
public class PokemonController {

    private final PokemonService service;

    public PokemonController(PokemonService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String pokemonform() {
        String testDitto = service.getPokemonPlainJSON();
        return testDitto;
    }
}
