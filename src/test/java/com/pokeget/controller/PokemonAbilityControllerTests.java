package com.pokeget.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pokeget.entity.Pokemon;
import com.pokeget.repository.PokemonRepository;
import com.pokeget.service.PokemonService;
import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
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

    @InjectMocks
    private PokemonAbilityController pokemonAbilityController;

    private List<Pokemon> mockPokemonList;

    Pokemon mockPokemon = new Pokemon("20", "Squirtle", "Water", "", "Torrent", 18, 20, 7);
    Pokemon mockPokemon2 = new Pokemon("21", "Bulbasaur", "Grass", "", "Overgrow", 2, 15, 1);
    Pokemon mockPokemon3 = new Pokemon("30", "Feraligtr", "Water", "", "Torrent", 84, 195, 160);


    @Before
    public void setup(){
        // allows creation of objects required for testing
        MockitoAnnotations.initMocks(this);

        mockPokemonList = new ArrayList<>();
        mockPokemonList.add(mockPokemon);
        mockPokemonList.add(mockPokemon2);
        mockPokemonList.add(mockPokemon3);

        // when method called, call it against the list
        when(pokemonRepository.findByAbility("Torrent")).thenReturn(mockPokemonList);
    }



    @Test
    public void getPokemonByAbility() throws Exception {

        String url = "/pokemon/ability/{ability}";
        mockMvc.perform(MockMvcRequestBuilders
                .get(url, "Torrent")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(convertObjectToJsonString(mockPokemonList)))
                .andReturn();

    }



// fix the object mapper method and test should work
    private String convertObjectToJsonString(List<Pokemon> mockPokemonList){
        try{
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(mockPokemonList);
        } catch (JsonProcessingException e){
            e.printStackTrace();
            throw new RuntimeException();
        }
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