package com.certant.pokedexlite.dao;

import com.certant.pokedexlite.exception.PokedexException;
import com.certant.pokedexlite.model.Ability;
import com.certant.pokedexlite.model.Evolution;
import com.certant.pokedexlite.model.Pokemon;
import com.certant.pokedexlite.model.Type;

import java.util.List;
import java.util.Optional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class PokemonDAOImpl implements PokemonDAO {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * Guarda un Pokemon
     * @param pokemon 
     * @throws PokedexException
     */
    @Override
    public void save(Pokemon pokemon) throws PokedexException {
        Session s = this.sessionFactory.openSession();
        Transaction t = s.beginTransaction();
        
        try {
            for (Type tmpTp : pokemon.getTypes()) {
                tmpTp.getPokemons().add(pokemon);
                s.update(tmpTp);
            }

            for (Ability tmpAy : pokemon.getAbilities()) {
                tmpAy.getPokemons().add(pokemon);
                s.update(tmpAy);
            }

            for (Evolution tmpEv : pokemon.getEvolutions()) {
                tmpEv.setPokemon(pokemon);
                s.update(tmpEv);
            }          

            s.save(pokemon);
        } 
        catch (Exception ex) {
            try {
                //Vuelve atras con los cambios realizados
                t.rollback();                
            } 
            catch (HibernateException he) { }
            
            //Captura la excepcion original, y lanza una excepcion de negocios
            PokedexException pe = new PokedexException(ex);
            pe.setTechnicalError(ex.getMessage());
            pe.setBusinessError("Imposible guardar el Pokemon");
            throw pe;               
        }
        finally {
            t.commit();
            s.close();            
        }        
    }

    /**
     * Lista todos los Pokemones
     * @return 
     * @throws PokedexException
     */
    @Override
    public List<Pokemon> findAll() throws PokedexException {
        Session s = this.sessionFactory.openSession();
        Transaction t = s.beginTransaction();
        
        List<Pokemon> pokemons;
        
        try {
            Query query = s.createQuery("from Pokemon pk", Pokemon.class);
            pokemons = query.list();       
        } 
        catch (Exception ex) {
            try {
                //Vuelve atras con los cambios realizados
                t.rollback();                
            } 
            catch (HibernateException he) { }
            
            //Captura la excepcion original, y lanza una excepcion de negocios
            PokedexException pe = new PokedexException(ex);
            pe.setTechnicalError(ex.getMessage());
            pe.setBusinessError("Imposible obtener los Pokemones");
            throw pe;               
        }
        finally {
            t.commit();
            s.close();            
        }
        
        return pokemons;         
    }

    /**
     * Retorna un Pokemon
     * El Pokemon se busca por id 
     * @param id
     * @return
     * @throws PokedexException
     */
    @Override
    public Optional<Pokemon> findById(Long id) throws PokedexException {
        Session s = this.sessionFactory.openSession();
        Transaction t = s.beginTransaction();
        
        Optional<Pokemon> pokemon;
        
        try {
            Query query = s.createQuery("from Pokemon pk WHERE pk.id = :id", Pokemon.class);
            query.setParameter("id", id);
            
            pokemon = (Optional<Pokemon>) query.list().get(0);        
        } 
        catch (Exception ex) {
            try {
                //Vuelve atras con los cambios realizados
                t.rollback();                
            } 
            catch (HibernateException he) { }
            
            //Captura la excepcion original, y lanza una excepcion de negocios
            PokedexException pe = new PokedexException(ex);
            pe.setTechnicalError(ex.getMessage());
            pe.setBusinessError("Imposible obtener el Pokemon por id");
            throw pe;               
        }
        finally {
            t.commit();
            s.close();            
        }
        
        return pokemon;        
    }

    /**
     * Retorna un Pokemon
     * El Pokemon se busca por nombre 
     * @param name
     * @return
     * @throws PokedexException
     */
    @Override
    public Optional<Pokemon> findByName(String name) throws PokedexException {
        Session s = this.sessionFactory.openSession();
        Transaction t = s.beginTransaction();
        
        Optional<Pokemon> pokemon;
        
        try {
            Query query = s.createQuery("from Pokemon pk WHERE pk.name = :name", Pokemon.class);
            query.setParameter("name", name);
            
            pokemon = (Optional<Pokemon>) query.list().get(0);        
        } 
        catch (Exception ex) {
            try {
                //Vuelve atras con los cambios realizados
                t.rollback();                
            } 
            catch (HibernateException he) { }
            
            //Captura la excepcion original, y lanza una excepcion de negocios
            PokedexException pe = new PokedexException(ex);
            pe.setTechnicalError(ex.getMessage());
            pe.setBusinessError("Imposible obtener el Pokemon por nombre");
            throw pe;               
        }
        finally {
            t.commit();
            s.close();            
        }
        
        return pokemon;         
    }
    
    /**
     * Actualiza los datos de un Pokemon, a partir del mismo Pokemon modificado
     * El Pokemon original se busca por id
     * @param modifiedPk 
     * @throws PokedexException
     */
    @Override
    public void update(Pokemon modifiedPk) throws PokedexException {
        Pokemon pokemon = findById(modifiedPk.getId()).get();
        
        Session s = this.sessionFactory.openSession();
        Transaction t = s.beginTransaction();
        
        try {
            pokemon.setName(modifiedPk.getName());

            for (Type tmpTp : pokemon.getTypes()) {
                tmpTp.removePokemon(pokemon);
                s.update(tmpTp);
            }

            for (Type tmpTp : modifiedPk.getTypes()) {
                tmpTp.addPokemon(pokemon);
                s.update(tmpTp);
            }

            pokemon.removeTypes();

            for (Type tmpTp : modifiedPk.getTypes()) {
                pokemon.addType(tmpTp);
            }

            pokemon.setLevelIsFound(modifiedPk.getLevelIsFound());

            s.update(pokemon);      
        } 
        catch (Exception ex) {
            try {
                //Vuelve atras con los cambios realizados
                t.rollback();                
            } 
            catch (HibernateException he) { }
            
            //Captura la excepcion original, y lanza una excepcion de negocios
            PokedexException pe = new PokedexException(ex);
            pe.setTechnicalError(ex.getMessage());
            pe.setBusinessError("Imposible actualizar el Pokemon");
            throw pe;               
        }
        finally {
            t.commit();
            s.close();            
        }       
    }

    /**
     * Elimina un Pokemon
     * @param pokemon 
     * @throws PokedexException
     */
    @Override
    public void delete(Pokemon pokemon) throws PokedexException {
        Session s = this.sessionFactory.openSession();
        Transaction t = s.beginTransaction();

        try {
            for (Type tmpTp : pokemon.getTypes()) {
                tmpTp.removePokemon(pokemon);
                s.update(tmpTp);
            }

            for (Ability tmpAy : pokemon.getAbilities()) {
                tmpAy.removePokemon(pokemon);
                s.update(tmpAy);
            }

            for (Evolution tmpEv : pokemon.getEvolutions()) {
                tmpEv.setPokemon(null);
                s.update(tmpEv);
            }         

            s.delete(pokemon);     
        } 
        catch (Exception ex) {
            try {
                //Vuelve atras con los cambios realizados
                t.rollback();                
            } 
            catch (HibernateException he) { }
            
            //Captura la excepcion original, y lanza una excepcion de negocios
            PokedexException pe = new PokedexException(ex);
            pe.setTechnicalError(ex.getMessage());
            pe.setBusinessError("Imposible eliminar el Pokemon");
            throw pe;               
        }
        finally {
            t.commit();
            s.close();            
        }           
    }
}
