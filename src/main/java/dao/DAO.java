package dao;

import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * \brief classe Dao mère qui sera la base de tous les sous dao.
 * @author sean anica, juliette rondeau, alhabaj mahmod
 * @version 1.0
 */
public class DAO {
    
    //Attributs
    private EntityManager em;

    /**
     * constructeur qui génère l'entity manager
     */
    public DAO() 
    {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jsfproject");
        this.setEm(entityManagerFactory.createEntityManager());
    }
    
    /**
     * getter de l'attribut entity manager
     * @return em
     */
    public EntityManager getEm() 
    {
        return em;
    }

    /**
     * setter de l'attribut entity manager
     * @param em
     */
    public void setEm(EntityManager em) {
        this.em = em;
    }

    

}