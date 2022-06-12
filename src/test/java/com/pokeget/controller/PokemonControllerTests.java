package com.pokeget.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pokeget.entity.Pokemon;
import com.pokeget.repository.PokemonRepository;
import com.pokeget.service.PokemonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(value = PokemonController.class, excludeAutoConfiguration = {SecurityAutoConfiguration.class})
public class PokemonControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PokemonService pokemonService;

    @MockBean
    private PokemonRepository pokemonRepository;

    // Data for the mock tests
    Pokemon mockPokemon = new Pokemon("20", "squirtle", "Water", "", "Torrent", 18, 20, 7);
    Pokemon mockPokemon2 = new Pokemon("21", "bulbasaur", "Grass", "", "Overgrow", 2, 15, 1);
    Pokemon mockPokemon3 = new Pokemon("22", "cyndaquil", "Fire", "", "Blaze", 1, 17, 155);


    @Test
    public void testGetAllPokemon() throws Exception
    {
        String url = "/pokemon/";
        mockMvc.perform(
                // mock get request
                get(url))
                // should return a 200 status
                .andExpect(status().isOk())
                // the content accessed should be JSON objects
                .andExpect(content().contentType(MediaType.APPLICATION_JSON)).
                andDo(print());
    }

    @Test
    public void testAddPokemon() throws Exception
    {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/pokemon/")
                .content(asJsonString(mockPokemon))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    /**
     * Transform the mock pokemon data into a JSON string for testing
     *
     * @param mockPokemon data to be turned into the JSON string
     * @return json string for the test or an error
     */
    public static String asJsonString(Pokemon mockPokemon) {

        try{
            // object mapper provides functionality for reading and writing JSON
            // serializes the passed in
            return new ObjectMapper().writeValueAsString(mockPokemon);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }


}
