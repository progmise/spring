package com.certant.pokedexlite.dao;

import com.certant.pokedexlite.exception.PokedexException;
import com.certant.pokedexlite.model.Type;

import java.util.List;
import java.util.Optional;

public interface TypeDAO {
    /* To save a type */
    public void save(Type type) throws PokedexException;
    
    /* Search all types */
    public List<Type> findAll() throws PokedexException;
    
    /* Get a type by id */
    public Optional<Type> findById(Long id) throws PokedexException;
    
    /* Get a type by name */
    public Optional<Type> findByName(String name) throws PokedexException;  
}