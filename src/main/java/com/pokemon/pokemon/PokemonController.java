package com.pokemon.pokemon;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PokemonController {

    @GetMapping("/")
    public String index(){
        return "index";
    }
}
