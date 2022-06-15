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

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = PokemonAbilityController.class, excludeAutoConfiguration = {SecurityAutoConfiguration.class})
public class PokemonAbilityControllerTests {

    // inject all dependencies
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PokemonService pokemonService;

    @MockBean
    private PokemonRepository pokemonRepository;

    @InjectMocks
    private PokemonAbilityController pokemonAbilityController;

    // pokemon object to run the test with
    Pokemon mockPokemon1 = new Pokemon("20", "Squirtle", "Water", "", "Torrent", 18, 20, 7);

    @Test
    public void getPokemonByAbility() throws Exception {

        when(pokemonService.getPokemonByAbility("Torrent")).thenReturn(List.of(mockPokemon1));

        String url = "/pokemon/ability/Torrent";
        mockMvc.perform(MockMvcRequestBuilders
                .get(url)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].ability").value("Torrent"))
                .andDo(print())
                .andExpect(status().isOk());

    }

}
