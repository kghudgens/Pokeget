package com.pokemon.pokemon;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PokemonService {

    private final RestTemplate restTemplate;

    public PokemonService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    /*
     * Method performs get request through the reset template builder
     *
     * @return String value of the queried resource
     */
    public String getPokemonPlainJSON() {
        // api address
        String url = "https://pokeapi.co/api/v2/pokemon/ditto";
        return this.restTemplate.getForObject(url, String.class);
    }
}