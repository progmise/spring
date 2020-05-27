package com.certant.pokedexlite.dao;

import com.certant.pokedexlite.exception.PokedexException;
import com.certant.pokedexlite.model.Evolution;

import java.util.Optional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class EvolutionDAOImpl implements EvolutionDAO {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * Guarda una Evolucion
     * @param evolution 
     * @throws PokedexException 
     */
    @Override
    public void save(Evolution evolution) throws PokedexException {
        Session s = this.sessionFactory.openSession();
        Transaction t = s.beginTransaction();
        
        try {
            s.save(evolution);
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
            pe.setBusinessError("Imposible guardar la Evolucion");
            throw pe;               
        }
        finally {
            t.commit();
            s.close();            
        }       
    }

    /**
     * Retorna una Evolucion
     * La Evolucion se busca por id 
     * @param id
     * @return 
     * @throws PokedexException 
     */
    @Override
    public Optional<Evolution> findById(Long id) throws PokedexException {
        Session s = this.sessionFactory.openSession();
        Transaction t = s.beginTransaction();

        Optional<Evolution> evolution;
        
        try {
            Query query = s.createQuery("from Evolution ev WHERE ev.id = :id", Evolution.class);
            query.setParameter("id", id);

            evolution = (Optional<Evolution>) query.list().get(0);           
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
            pe.setBusinessError("Imposible obtener la Evolucion por id");
            throw pe;               
        }
        finally {
            t.commit();
            s.close();            
        }
        
        return evolution;        
    }
}