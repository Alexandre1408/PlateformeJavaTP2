package orm;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import entities.Commentaire;

public class CommentaireOrm  extends MainOrm
{
	
	public CommentaireOrm()
	{
		super();
	}

	public void ajouterCommentaire(Commentaire commentaireAjouter) 
	{
		System.out.println(commentaireAjouter.getText());
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
    public List<Commentaire> trouverTousCommentaireLimiter(int limit) 
    {
        String selectJPQL = "SELECT c FROM Commentaire c ORDER BY c.date DESC";
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
}
