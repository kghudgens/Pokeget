package com.pokeget.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pokeget.entity.Pokemon;
import com.pokeget.repository.PokemonRepository;
import com.pokeget.service.PokemonService;
import com.sun.net.httpserver.Authenticator;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;
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

    String endPoint = "/pokemon/";

    @Test
    public void testGetAllPokemon() throws Exception
    {

        when(pokemonService.getAll()).thenReturn(List.of(mockPokemon));

        mockMvc.perform(MockMvcRequestBuilders
                // mock get request
                .get(endPoint))
                // should return a 200 status
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name", Matchers.is("squirtle")))
                // the content accessed should be JSON objects
                .andExpect(content().contentType(MediaType.APPLICATION_JSON)).
                andDo(print());

        verify(pokemonService).getAll();
    }

    @Test
    public void testAddPokemon() throws Exception
    {
        mockMvc.perform(MockMvcRequestBuilders
                .post(endPoint)
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(mockPokemon))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }


    @Test
    public void testDeletePokemon() throws Exception
    {
        willDoNothing().given(pokemonService).deletePokemonByID("20");

        String deleteEndPoint = "/pokemon/{id}";
        mockMvc.perform(MockMvcRequestBuilders.delete(deleteEndPoint, "20"))
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
