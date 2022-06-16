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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = PokemonNameController.class, excludeAutoConfiguration = {SecurityAutoConfiguration.class})
public class PokemonNameControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // mock bean creates the behavior of the class it declares for the test case
    @MockBean
    private PokemonService pokemonService;

    @MockBean
    private PokemonRepository pokemonRepository;

    // data to test against
    Pokemon mockPokemon = new Pokemon("21", "Venusaur", "Grass", "Poison", "Overgrow", 72, 220, 3);

    @Test
    public void getPokemonByName() throws Exception
    {
//        when the pkservice method is called return the pokemon object to compare against
        when(pokemonService.findPokemonByName("Venusaur")).thenReturn(List.of(mockPokemon));


        String url  = "/pokemon/name/{name}";
        mockMvc.perform(MockMvcRequestBuilders
                .get(url, "Venusaur")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name", Matchers.is("Venusaur")))
                .andDo(print())
                .andExpect(status().isOk());

        // ensure that correct method is being called
        verify(pokemonService).findPokemonByName("Venusaur");
    }
}
