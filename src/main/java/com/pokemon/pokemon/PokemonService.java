package com.pokemon.pokemon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Service
public class PokemonService {

    // The rest client - actual component making the request to APIs
    private final RestTemplate restTemplate;

    // Autowired points to the rest template instance
    @Autowired
    public PokemonService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build();
    }

    public String getPokemonPlainJSON(){
        String url = "https://pokeapi.co/api/v2/pokemon/ditto";
        return this.restTemplate.getForObject(url, String.class);
    }
}
