package com.certant.pokedexlite.dao;

import com.certant.pokedexlite.exception.PokedexException;
import com.certant.pokedexlite.model.Pokemon;

import java.util.List;
import java.util.Optional;

public interface PokemonDAO {
    /* To save a pokemon */
    public void save(Pokemon pokemon) throws PokedexException;
    
    /* Search all pokemons */
    public List<Pokemon> findAll() throws PokedexException;
    
    /* Get a pokemon by id */
    public Optional<Pokemon> findById(Long id) throws PokedexException;
    
    /* Get a pokemon by name */
    public Optional<Pokemon> findByName(String name) throws PokedexException;
    
    public void update(Pokemon modifiedPk) throws PokedexException;
    
    /* Delete a pokemon */
    public void delete(Pokemon pokemon) throws PokedexException;
}