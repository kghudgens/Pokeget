package com.pokeget.controller;

import com.pokeget.entity.Pokemon;
import com.pokeget.repository.PokemonRepository;
import com.pokeget.service.PokemonService;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = PokemonTypeController.class, excludeAutoConfiguration = {SecurityAutoConfiguration.class})
public class PokemonTypeControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PokemonService pokemonService;

    @MockBean
    private PokemonRepository pokemonRepository;

    Pokemon mockPokemon = new Pokemon("1", "Togetic", "Fairy", "Flying", "Serene Grace", 24, 7,176);

    @Test
    public void getByTypeTest() throws Exception
    {
        String type = "Fairy";

        when(pokemonService.getPokemonByType(type)).thenReturn(List.of(mockPokemon));

        String url = "/pokemon/type/{type}";

        MvcResult result  = mockMvc.perform(MockMvcRequestBuilders
                .get(url, type)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].type1", Matchers.is(type)))
                .andExpect(status().isOk())
                .andReturn();

        verify(pokemonService).getPokemonByType("Fairy");

    }

}
