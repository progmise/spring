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
@Table(name = "types")
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tp_id")
    private Long id;
    
    @Column(name = "tp_name")
    private String name;
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @OrderBy("id")
    private Set<Pokemon> pokemons = new HashSet<Pokemon>();
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @OrderBy("id")
    private Set<Evolution> evolutions = new HashSet<Evolution>();    

    public Type() {
    }

    public Type(String name) {
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
        pokemon.getTypes().add(this);
    }

    public void removePokemon(Pokemon pokemon) {
        if (!pokemons.contains(pokemon)) return; 
        
        pokemons.remove(pokemon);
        pokemon.getTypes().remove(this);
    } 
    
    public void removePokemons() {
        new HashSet<>(pokemons).forEach(tmpPk -> {
            removePokemon(tmpPk);
        });
    }
    
    
    public Set<Evolution> getEvolutions() {
        return new HashSet<>(evolutions);
    }

    public void addEvolution(Evolution evolution) {
        if (evolutions.contains(evolution)) return; 
        
        evolutions.add(evolution);
        evolution.getTypes().add(this);
    }

    public void removeEvolution(Evolution evolution) {
        if (!evolutions.contains(evolution)) return; 
        
        evolutions.remove(evolution);
        evolution.getTypes().remove(this);
    } 
    
    public void removeEvolutions() {
        new HashSet<>(evolutions).forEach(tmpEv -> {
            removeEvolution(tmpEv);
        });
    }    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.name);
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
        final Type other = (Type) obj;
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
        return "Type{" + "id=" + id + ", name=" + name + '}';
    }
}