package com.pokemon.pokemon;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Need to use controller because thymeleaf does not support rest controller
@Controller
public class PokemonController {

    @GetMapping
    public String index(){
        return "index";
    }
}
