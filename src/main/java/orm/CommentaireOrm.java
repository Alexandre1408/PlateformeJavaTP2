package orm;

import java.util.List;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

import entities.Commentaire;

/***
 * Classe CommentaireOrm qui est gère les interactions entre la classe commentaires et la base données
 * Herite de MainOrm
 * @author BELDA Tom, INGARAO Adrien, MAGGOUH Naoufal, UNG Alexandre
 *
 */
public class CommentaireOrm  extends MainOrm
{
	/**
	* @brief constructeur de CommentaireOrm
	*/
	public CommentaireOrm()
	{
		super();
	}

	/**
	 * Ajoute le commentaire passée en paramètre dans la base de données
	 * @param commentaireAjouter le commentaire à ajouter
	 */
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
	
	/**
	* @brief Ajoute le commentaire passée en paramètre dans la base de données
	* @param commentaireASupprimer le commentaire à supprimer
	*/
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
	
	/***
	* @brief augmente le nombre de j'aime du commentaire passée en paramètre dans la base de données
	* @param commentaireAimer le commentaire à aimer
	*/
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
	
	/**
	 * @brief Renvoie le nombre de commentaires passée en paramètre
	 * @param limit le nombre de commentaires renvoyés
	 * @return La liste des commentaires renvoyés
	 */
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
	
	/**
	 * @brief Renvoie tous les commentaires
	 * @param limit, le nombre de commentaires renvoyés
	 * @return La liste des commentaires renvoyés
	 */
	@SuppressWarnings("unchecked")
    public List<Commentaire> trouverTousCommentaire() 
    {
        String selectJPQL = "SELECT c FROM Commentaire c ORDER BY c.date DESC";
        List<Commentaire> resultList = null;
        Query query = em.createQuery(selectJPQL);
        
        try
        {
            resultList = (List<Commentaire>)query.getResultList();
        }
        catch(PersistenceException e)
        {
            System.out.println(e.getMessage());
        }
        return resultList;
    }
}
