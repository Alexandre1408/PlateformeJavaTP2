package orm;

import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 * \brief 
 * @version 1.0
 */
public class MainOrm 
{
    
    protected EntityManager em;
    protected EntityManagerFactory emf;

    /**
     * constructeur qui génère l'entity manager
     */
    public MainOrm() 
    {
		emf  = Persistence.createEntityManagerFactory("jsfproject");
        em = emf.createEntityManager();
    }

    /**
     * getter de l'attribut entity manager
     * @return em
     */
    public EntityManager getEm() 
    {
        return em;
    }

}