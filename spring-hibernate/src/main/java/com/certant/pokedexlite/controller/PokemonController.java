package com.certant.pokedexlite.controller;

import com.certant.pokedexlite.dao.PokemonDAO;
import com.certant.pokedexlite.exception.PokedexException;
import com.certant.pokedexlite.model.Pokemon;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PokemonController {
    PokemonDAO pokemonDAO;

    public void setPokemonDAO(PokemonDAO pokemonDAO) {
        this.pokemonDAO = pokemonDAO;
    }
    
    /**
     * Envía a la vista, el Pokemon solicitado por uri, en formato JSON
     * El Pokemon se obtiene por id
     * @param id
     * @return 
     * @throws PokedexException
     */
    @GetMapping("/pokemon/{id}")
    public ResponseEntity<Pokemon> getPokemonById(@PathVariable(value = "id") Long id) throws PokedexException {
        Optional<Pokemon> optionalPk = pokemonDAO.findById(id);
        
        if (!optionalPk.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        
        Pokemon pk = optionalPk.get();
        
        //PokemonWrapper wp = new PokemonWrapper(pk);
        
        return ResponseEntity.ok().body(pk);
    }    
}
