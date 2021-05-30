package orm;

import java.util.List;

import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import entities.Commentaire;
import entities.Membre;

/**
 * \brief 
 * @version 1.0
 */
public class MainOrm 
{
    
    private EntityManager em;
	private EntityManagerFactory emf;

    /**
     * constructeur qui génère l'entity manager
     */
    public MainOrm() 
    {
		emf  = Persistence.createEntityManagerFactory("jsfproject");
        em = emf.createEntityManager() ;
    }

    
	public void ajouterMembre(Membre membreAjouter) 
	{
		try
		{
			em.getTransaction().begin();
			em.persist(membreAjouter);
			em.getTransaction().commit();
		}
		catch (PersistenceException e) 
		{
			em.getTransaction().rollback();
			System.out.println(e.getMessage());
		}		
	}
	
	public void ajouterCommentaire(Commentaire commentaireAjouter) 
	{
		try
		{
			em.getTransaction().begin();
			em.persist(commentaireAjouter);
			em.getTransaction().commit();
		}
		catch (PersistenceException e) 
		{
			em.getTransaction().rollback();
			System.out.println(e.getMessage());
		}		
	}
	
	public void supprimerMembre(Membre membreASupprimer) 
	{
		try
		{
			em.getTransaction().begin();
			em.remove(membreASupprimer);
			em.getTransaction().commit();
		}
		catch (PersistenceException e) 
		{
			em.getTransaction().rollback();
			System.out.println(e.getMessage());
		}		
	}
	
	public void supprimerCommentaire(Commentaire commentaireASupprimer) 
	{
		try
		{
			em.getTransaction().begin();
			em.remove(commentaireASupprimer);
			em.getTransaction().commit();
		}
		catch (PersistenceException e) 
		{
			em.getTransaction().rollback();
			System.out.println(e.getMessage());
		}		
	}
	
	public void aimerCommentaire(Commentaire commentaireAimer) 
	{
		try
		{
			em.getTransaction().begin();
			commentaireAimer.augmenterJaime();
			em.getTransaction().commit();
		}
		catch (PersistenceException e) 
		{
			em.getTransaction().rollback();
			System.out.println(e.getMessage());
		}		
	}
	
	@SuppressWarnings("unchecked")
	public List<Commentaire> trouverTopCommentaireLimiter(int limit) 
	{
		String selectJPQL = "SELECT c FROM Commentaire c ORDER BY c.nombreJaime DESC";
		List<Commentaire> resultList = null;
		Query query = em.createQuery(selectJPQL);
		
		try
		{
			resultList = (List<Commentaire>)query.setMaxResults(limit).getResultList();
		}
		catch(PersistenceException e)
		{
			System.out.println(e.getMessage());
		}
		return resultList;
	}
	
	@SuppressWarnings("unchecked")
	public List<Membre> trouverTousLesMembres() 
	{
		String selectJPQL = "SELECT m FROM Membre m";
		List<Membre> resultList = null;
		Query query = em.createQuery(selectJPQL);
		
		try
		{
			resultList = (List<Membre>)query.getResultList();
		}
		catch(PersistenceException e)
		{
			System.out.println(e.getMessage());
		}
		return resultList;
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