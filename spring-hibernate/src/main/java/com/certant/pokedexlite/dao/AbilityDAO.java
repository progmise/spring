package com.certant.pokedexlite.dao;

import com.certant.pokedexlite.exception.PokedexException;
import com.certant.pokedexlite.model.Ability;

import java.util.List;
import java.util.Optional;

public interface AbilityDAO {
    /* Get all abilities */
    public List<Ability> findAll() throws PokedexException;
    
    /* Get an ability by id */
    public Optional<Ability> findById(Long id) throws PokedexException;    
}