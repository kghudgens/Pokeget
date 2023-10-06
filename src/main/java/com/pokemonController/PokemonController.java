package com.pokemonController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pokemonModel.Pokemon;

@Controller
@RequestMapping("/api")
public class PokemonController {

    @Autowired
    private Pokemon pokemon;

    String API = "https://pokeapi.co/api/v2/pokemon/";

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello";
    }

    @GetMapping("/name")
    public Pokemon getByName(String name) {
        String result = API + name;
        return result;
    }
}