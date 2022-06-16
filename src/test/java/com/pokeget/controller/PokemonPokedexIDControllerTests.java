package com.pokeget.controller;

import com.pokeget.entity.Pokemon;
import com.pokeget.repository.PokemonRepository;
import com.pokeget.service.PokemonService;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
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

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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

    @InjectMocks
    private PokemonPokedexIDController pokemonPokedexIDController;

    Pokemon mockPokemon2 = new Pokemon("21", "Venusaur", "Grass", "Poison", "Overgrow", 72, 220, 3);

    @Test
    public void testGetByPokeDexID() throws Exception
    {
        // data structure acts as repository
        when(pokemonService.getPokemonByID(3)).thenReturn(List.of(mockPokemon2));

        String url = "/pokemon/pokedexID/{pokedexID}";
        mockMvc.perform(MockMvcRequestBuilders
                        .get(url, 3)
                        .accept(MediaType.APPLICATION_JSON))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.size()", Matchers.is(1)))
                        .andExpect(MockMvcResultMatchers.jsonPath("$[0].pokedexID", Matchers.is(3)))
                        .andExpect(status().isOk())
                        .andDo(print())
        ;

        verify(pokemonService).getPokemonByID(3);
    }


}
