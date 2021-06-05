package orm;

import java.util.List;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

import entities.Membre;

/***
 * Classe CommentaireOrm qui est g�re les interactions entre la classe commentaires et la base donn�es
 * Herite de MainOrm
 * @author BELDA Tom, INGARAO Adrien, MAGGOUH Naoufal, UNG Alexandre
 *
 */
public class MembreOrm extends MainOrm {

	public MembreOrm()
	{
		super();
	}
	
	/**
	* Ajoute le membre pass�e en param�tre dans la base de donn�es
	* @param membreAjouter � ajouter dans la base de donn�es
	*/
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
	
	/**
	* Ajoute le membre pass�e en param�tre dans la base de donn�es
	* @param membreASupprimer � ajouter dans la base de donn�es
	*/
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

	/**
	 * Renvoie une liste de tous les membres de la base de donn�es
	 * @return la liste des membres renvoy�s
	 */
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
	* Renvoie si le mail pass�e en param�tre est d�j� dans la base de donn�es
	* @param mail
	* @return true si le mail est trouv� dans la bdd, false sinon
	*/
    @SuppressWarnings("unchecked")
    public boolean mailDejaUtilise(String mail) 
    {
        String selectJPQL = "SELECT m FROM Membre m WHERE m.mail=:mail";
        List<Membre> resultList = null;
        Query query = em.createQuery(selectJPQL);
        query.setParameter("mail", mail);
        try
        {
            resultList = (List<Membre>)query.getResultList();
        }
        catch(PersistenceException e)
        {
            System.out.println(e.getMessage());
        }
        return resultList.isEmpty();
    }	
}
