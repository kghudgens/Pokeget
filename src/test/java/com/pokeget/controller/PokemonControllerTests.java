package com.pokeget.controller;

import com.pokeget.entity.Pokemon;
import com.pokeget.repository.PokemonRepository;
import com.pokeget.service.PokemonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(value = PokemonController.class)
//@WithMockUser
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

    // test is failing
    // need to integrate the newly created data for test
    @Test
    public void testGetAll() throws Exception {
        String url = "/pokemon";
        mockMvc.perform(get(url)).andExpect(status().isOk()).andExpect(content().json());
    }



}
