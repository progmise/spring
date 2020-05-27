package com.certant.pokedexlite.dao;

import com.certant.pokedexlite.exception.PokedexException;
import com.certant.pokedexlite.model.Ability;

import java.util.List;
import java.util.Optional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class AbilityDAOImpl implements AbilityDAO {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    /**
     * Retorna una Habilidad
     * La Habilidad se busca por id
     * @param id
     * @return 
     * @throws PokedexException 
     */
    @Override
    public Optional<Ability> findById(Long id) throws PokedexException {
        Session s = this.sessionFactory.openSession();
        Transaction t = s.beginTransaction();
        
        Optional<Ability> ability;
        
        try {
            Query query = s.createQuery("from Ability ay WHERE ay.id = :id", Ability.class);
            query.setParameter("id", id);

            ability = (Optional<Ability>) query.list().get(0);            
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
            pe.setBusinessError("Imposible obtener la Habilidad por id");
            throw pe;               
        }
        finally {
            t.commit();
            s.close();            
        }
        
        return ability;
    }

    /**
     * Lista todas las Habilidades
     * @return 
     * @throws PokedexException 
     */
    @Override
    public List<Ability> findAll() throws PokedexException {
        Session s = this.sessionFactory.openSession();
        Transaction t = s.beginTransaction();
        
        List<Ability> abilities;
        
        try {
            Query query = s.createQuery("from Ability ay", Ability.class);
            abilities = query.list();         
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
            pe.setBusinessError("Imposible obtener las Habilidades");
            throw pe;               
        }
        finally {
            t.commit();
            s.close();            
        }
        
        return abilities;        
    }
}