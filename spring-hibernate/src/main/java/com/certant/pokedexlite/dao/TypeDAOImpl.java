package com.certant.pokedexlite.dao;

import com.certant.pokedexlite.exception.PokedexException;
import com.certant.pokedexlite.model.Type;

import java.util.List;
import java.util.Optional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class TypeDAOImpl implements TypeDAO {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * Guarda un Tipo
     * @param type
     * @throws PokedexException
     */    
    @Override
    public void save(Type type) throws PokedexException {
        Session s = this.sessionFactory.openSession();
        Transaction t = s.beginTransaction();
        
        try {
            s.save(type);
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
            pe.setBusinessError("Imposible guardar el Tipo");
            throw pe;               
        }
        finally {
            t.commit();
            s.close();            
        }          
    }

    /**
     * Lista todos los Tipos
     * @return
     * @throws PokedexException
     */    
    @Override
    public List<Type> findAll() throws PokedexException {
        Session s = this.sessionFactory.openSession();
        Transaction t = s.beginTransaction();
        
        List<Type> types;
        
        try {
            Query query = s.createQuery("from Type tp", Type.class);
            types = query.list();     
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
            pe.setBusinessError("Imposible obtener los Tipos");
            throw pe;               
        }
        finally {
            t.commit();
            s.close();            
        }
        
        return types;        
    }

    /**
     * Retorna un Tipo
     * El Tipo se busca por id 
     * @param id
     * @return
     * @throws PokedexException
     */
    @Override
    public Optional<Type> findById(Long id) throws PokedexException {
        Session s = this.sessionFactory.openSession();
        Transaction t = s.beginTransaction();

        Optional<Type> type;
        
        try {
            Query query = s.createQuery("from Type tp WHERE tp.id = :id", Type.class);
            query.setParameter("id", id);
            
            type = (Optional<Type>) query.list().get(0);
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
            pe.setBusinessError("Imposible obtener el Tipo por id");
            throw pe;               
        }
        finally {
            t.commit();
            s.close();            
        }
        
        return type;        
    }
    
    /**
     * Retorna un Tipo
     * El Tipo se busca por nombre 
     * @param name
     * @return
     * @throws PokedexException
     */
    @Override
    public Optional<Type> findByName(String name) throws PokedexException {
        Session s = this.sessionFactory.openSession();
        Transaction t = s.beginTransaction();

        Optional<Type> type;
        
        try {
            Query query = s.createQuery("from Type tp WHERE tp.name = :name", Type.class);
            query.setParameter("name", name);
            
            type = (Optional<Type>) query.list().get(0);    
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
            pe.setBusinessError("Imposible obtener el Tipo por nombre");
            throw pe;               
        }
        finally {
            t.commit();
            s.close();            
        }
        
        return type;        
    }
}
