package com.pokeget.controller;

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

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(value = PokemonPokedexIDController.class, excludeAutoConfiguration = {SecurityAutoConfiguration.class})
public class PokemonPokedexIDControllerTests {

    //inject a mockmvc instance
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PokemonService pokemonService;

    @MockBean
    private PokemonRepository pokemonRepository;

    @Test
    public void testGetByPokeDexID() throws Exception
    {
        String url = "/pokemon/pokedexID/{pokedexID}";
        mockMvc.perform(MockMvcRequestBuilders
                        .get(url, 9)
                        .accept(MediaType.APPLICATION_JSON))
                        .andDo(print())
                        .andExpect(status().isOk());

    }


}
