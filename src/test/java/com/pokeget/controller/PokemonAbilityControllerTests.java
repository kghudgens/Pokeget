package com.pokeget.controller;

import com.pokeget.repository.PokemonRepository;
import com.pokeget.service.PokemonService;
import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = PokemonAbilityController.class, excludeAutoConfiguration = {SecurityAutoConfiguration.class})
public class PokemonAbilityControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PokemonService pokemonService;

    @MockBean
    private PokemonRepository pokemonRepository;

    @Test
    public void getPokemonByName() throws Exception {

        String url = "/pokemon/ability/{ability}";
        mockMvc.perform(MockMvcRequestBuilders
                .get(url, "Torrent")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                // !figure out how to use json path to test value
                .andExpect(jsonPath("$.ability").value("Torrent"));

    }


}

//{
//        "id": "1",
//        "name": "Blastoise",
//        "type1": "Water",
//        "type2": "",
//        "ability": "Torrent",
//        "height": 63,
//        "weight": 188,
//        "pokedexID": 9
//        },