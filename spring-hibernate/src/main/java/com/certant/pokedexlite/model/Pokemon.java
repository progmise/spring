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
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name = "pokemons")
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_id")
    private Long id;
    
    @Column(name = "pk_name")
    private String name;
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE, mappedBy = "pokemons")
    @OrderBy("id")
    private Set<Type> types = new HashSet<Type>();       
    
    @Column(name = "pk_level_is_found")
    private Integer levelIsFound;
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE, mappedBy = "pokemons")
    @OrderBy("id")
    private Set<Ability> abilities = new HashSet<Ability>(); 
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "pokemon")
    private Set<Evolution> evolutions = new HashSet<Evolution>();          

    public Pokemon() {
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
    
    public Set<Type> getTypes() {
        return new HashSet<>(types);
    }

    public void addType(Type type) {
        if (types.contains(type)) return;  
        
        types.add(type);
        type.getPokemons().add(this);
    }

    public void removeType(Type type) {
        if (!types.contains(type)) return;
        
        types.remove(type);
        type.getPokemons().remove(this);
    } 
    
    public void removeTypes() {
        new HashSet<>(types).forEach(tmpTp -> {
            removeType(tmpTp);
        });
    }
    
    public Integer getLevelIsFound() {
        return levelIsFound;
    }

    public void setLevelIsFound(Integer levelIsFound) {
        this.levelIsFound = levelIsFound;
    }
    
    public Set<Ability> getAbilities() {
        return new HashSet<>(abilities);
    }

    public void addAbility(Ability ability) {
        if (abilities.contains(ability)) return;  
        
        abilities.add(ability);
        ability.getPokemons().add(this);
    }

    public void removeAbility(Ability ability) {
        if (!abilities.contains(ability)) return;
        
        abilities.remove(ability);
        ability.getPokemons().remove(this);
    } 
    
    public void removeAbilities() {
        new HashSet<>(abilities).forEach(tmpAy -> {
            removeAbility(tmpAy);
        });
    }
    
    
    public Set<Evolution> getEvolutions() {
        return new HashSet<>(evolutions);
    }

    public void addEvolution(Evolution evolution) {
        if (evolutions.contains(evolution)) return;  
        
        evolutions.add(evolution);
        evolution.setPokemon(this);
    }

    public void removeEvolution(Evolution evolution) {
        if (!evolutions.contains(evolution)) return;
        
        evolutions.remove(evolution);
        evolution.setPokemon(null);
    } 
    
    public void removeEvolutions() {
        new HashSet<>(evolutions).forEach(tmpEv -> {
            removeEvolution(tmpEv);
        });
    }    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + Objects.hashCode(this.name);
        hash = 29 * hash + Objects.hashCode(this.levelIsFound);
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
        final Pokemon other = (Pokemon) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.levelIsFound, other.levelIsFound)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "Pokemon{" + "id=" + id + ", name=" + name + ", levelIsFound=" + levelIsFound + '}';
    }
}