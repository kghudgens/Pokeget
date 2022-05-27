package com.pokemon.pokemon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

// Need to use controller because thymeleaf does not support rest controller
@Controller
public class PokemonController {

    private final PokemonService service;

    @Autowired
    public PokemonController(PokemonService service){
        this.service = service;
    }

    @GetMapping("/")
    public String pokemonform(Model model){

        return "index";
    }
}
