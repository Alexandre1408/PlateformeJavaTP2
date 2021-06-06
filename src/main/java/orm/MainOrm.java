package orm;

import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/***
 * Classe mère MainOrm qui contient les EntityManager et la factory
 *  
 * @author BELDA Tom, INGARAO Adrien, MAGGOUH Naoufal, UNG Alexandre
 *
 */
public class MainOrm 
{
    protected EntityManager em;
    protected EntityManagerFactory emf;

    /**
     * @brief Constructeur qui génère l'entity manager
     */
    public MainOrm() 
    {
		emf  = Persistence.createEntityManagerFactory("jsfproject");
        em = emf.createEntityManager();
    }

    /**
     * @brief getter de l'attribut entity manager
     * @return em
     */
    public EntityManager getEm() 
    {
        return em;
    }

}