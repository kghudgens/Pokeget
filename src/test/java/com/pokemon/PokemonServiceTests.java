package com.pokemon;

import com.pokemon.pokemon.PokemonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class PokemonServiceTests {

    @Autowired
    private PokemonService pkService;

    @Test
    public void testGetPokemonPlainJSON(){
        String obj = pkService.getPokemonPlainJSON();
        System.out.println(obj);
        // should assert false because the string is now the json string object
        assertFalse(obj.isEmpty());
    }

}
