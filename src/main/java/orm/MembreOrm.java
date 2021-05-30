package orm;

import java.util.List;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

import entities.Membre;

public class MembreOrm extends MainOrm {

	public MembreOrm()
	{
		super();
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
	
}
