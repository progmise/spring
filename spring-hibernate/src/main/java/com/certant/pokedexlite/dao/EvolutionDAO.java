package com.certant.pokedexlite.dao;

import com.certant.pokedexlite.exception.PokedexException;
import com.certant.pokedexlite.model.Evolution;

import java.util.Optional;

public interface EvolutionDAO {
    /* To save an evolution */
    public void save(Evolution evolution) throws PokedexException;

    /* Get an evolution by id */
    public Optional<Evolution> findById(Long id) throws PokedexException;     
}