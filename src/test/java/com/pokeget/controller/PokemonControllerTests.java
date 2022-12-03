package com.pokeget.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pokeget.Pokemon.PokemonEntity;
import com.pokeget.Pokemon.PokemonController;
import com.pokeget.Pokemon.PokemonRepository;
import com.pokeget.service.PokemonService;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
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

import java.util.ArrayList;
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

    private final String END_POINT = "/pokemon/";
    private List<PokemonEntity> mockList = new ArrayList<>();

    @BeforeAll
    public void init() {
        PokemonEntity mockSquirtle = new PokemonEntity("20", "squirtle", "Water", "", "Torrent", 18, 20, 7);
        PokemonEntity mockWartortle = new PokemonEntity("21", "Wartortle", "Water", "", "Torrent", 18, 20, 8);
        PokemonEntity mockBlastoise = new PokemonEntity("22", "Blastoise", "Water", "", "Torrent", 18, 20, 9);

        mockList.add(mockSquirtle);
        mockList.add(mockWartortle);
        mockList.add(mockBlastoise);

    }


    @Test
    public void testGetAllPokemon() throws Exception {

        when(pokemonService.getAll()).thenReturn(mockList);

        mockMvc.perform(MockMvcRequestBuilders
                        // mock get request
                        .get(END_POINT))
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
    public void getPokemonByAbility() throws Exception {

        when(pokemonService.getPokemonByAbility("Torrent")).thenReturn(mockList);

        String url = "/pokemon/ability/Torrent";
        mockMvc.perform(MockMvcRequestBuilders
                        .get(url)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].ability").value("Torrent"))
                .andDo(print())
                .andExpect(status().isOk());

        verify(pokemonService).getPokemonByAbility("Torrent");
    }

    @Test
    public void testGetPokemonByName() throws Exception {
        when(pokemonService.getPokemonByName("squirtle")).thenReturn(mockList.get(0));

        String url = "/pokemon/name/{name}";
        mockMvc.perform(MockMvcRequestBuilders
                        .get(url, "squirtle")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name", Matchers.is("squirtle")))
                .andDo(print())
                .andExpect(status().isOk());

        // ensure that correct method is being called
        verify(pokemonService).getPokemonByName("squirtle");
    }

    @Test
    public void testGetByPokeDexID() throws Exception {
        when(pokemonService.getPokemonByID(7)).thenReturn(mockList.get(0));

        String url = "/pokemon/pokedexID/{pokedexID}";
        mockMvc.perform(MockMvcRequestBuilders
                        .get(url, 7)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].pokedexID", Matchers.is(7)))
                .andExpect(status().isOk())
                .andDo(print())
        ;

        verify(pokemonService).getPokemonByID(7);
    }

    @Test
    public void testGetByType() throws Exception {
        String type = "Water";

        when(pokemonService.getPokemonByType(type)).thenReturn(mockList);

        String url = "/pokemon/type/{type}";

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .get(url, type)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].type1", Matchers.is(type)))
                .andExpect(status().isOk())
                .andReturn();

        verify(pokemonService).getPokemonByType("Water");

    }


    @Test
    public void testAddPokemon() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .post(END_POINT)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(mockList.get(0)))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    public void testDeletePokemon() throws Exception {
        willDoNothing().given(pokemonService).deletePokemonByID("20");

        String deleteEndPoint = "/pokemon/{id}";
        mockMvc.perform(MockMvcRequestBuilders.delete(deleteEndPoint, "20"))
                .andExpect(status().isOk());
    }

    /**
     * Transform the mock pokemon data into a JSON string for testing
     *
     * @param mockPokemonEntity data to be turned into the JSON string
     * @return json string for the test or an error
     */
    public static String asJsonString(PokemonEntity mockPokemonEntity) {

        try {
            // object mapper provides functionality for reading and writing JSON
            // serializes the passed in
            return new ObjectMapper().writeValueAsString(mockPokemonEntity);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
