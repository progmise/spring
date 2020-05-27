package com.certant.pokedexlite.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name = "abilities")
public class Ability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aty_id")
    private Long id;
    
    @Column(name = "aty_name")
    private String name;
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @OrderBy("id")
    private Set<Pokemon> pokemons = new HashSet<Pokemon>();  

    public Ability() {
    }

    public Ability(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Pokemon> getPokemons() {
        return new HashSet<>(pokemons);
    }

    public void addPokemon(Pokemon pokemon) {
        if (pokemons.contains(pokemon)) return;  
        
        pokemons.add(pokemon);
        pokemon.getAbilities().add(this);
    }

    public void removePokemon(Pokemon pokemon) {
        if (!pokemons.contains(pokemon)) return;
        
        pokemons.remove(pokemon);
        pokemon.getAbilities().remove(this);
    } 
    
    public void removePokemons() {
        new HashSet<>(pokemons).forEach(tmpPk -> {
            removePokemon(tmpPk);
        });
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
        hash = 37 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ability other = (Ability) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ability{" + "id=" + id + ", name=" + name + '}';
    }
}