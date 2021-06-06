package beans;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import entities.Commentaire;
import orm.CommentaireOrm;

/***
 * Classe Beans pour les commentaires et top commentaires
 *  
 * @author BELDA Tom, INGARAO Adrien, MAGGOUH Naoufal, UNG Alexandre
 *
 */
@Named
@RequestScoped
public class CommentairesBean implements Serializable {

	private static final long serialVersionUID = 3199686126907808648L;

	//Variable représentant le numéro de la page commentaire ouverte
	private static int currentPage = 1;

	//Lien avec la base de données
	private CommentaireOrm orm;
	//Liste des top commentaires
	private List<Commentaire> topComments;
	//Liste des commentaires pour la page
	private List<Commentaire> comments;
	//Liste des commentaires
	private List<Commentaire> allComments;

	//Variable représentant le numéro de la page commentaire ouverte
	private int curPag;
	
	//Contenu du commentaire a publier
	private String tempText;
    
	
    @PostConstruct
    public void init()
    {
		orm = new CommentaireOrm();
		setCurPag(currentPage);
		updateComments();
    }
	
    /**
     * @brief met à jour tous les tableaux de commentaire
     */
	public void updateComments()
	{
	
		setTopComments(orm.trouverTopCommentaireLimiter(3));
		setAllComments(orm.trouverTousCommentaire());
		initPageComments();
	}
	
	/**
	 * @brief met à jour les commentaires en fonction de la page ouverte
	 */
	public void initPageComments()
	{
		if(allComments != null)
		{
			if(allComments.size() >= (curPag*10))
				setComments(allComments.subList((curPag-1)*10, (curPag*10)));
			else
			{
				setComments(allComments.subList((curPag-1)*10, allComments.size()));
			}
		}

	}
	
	/**
	 * @brief aime un commentaire
	 * @param id id du commentaire a aimer
	 */
	public void likeComment(int id)
	{
		for(int ind = 0; ind < allComments.size(); ind++)
		{
			if(allComments.get(ind).getIdCommentaire() == id)
				orm.aimerCommentaire(allComments.get(ind));
			updateComments();
		}
	}
	
	/**
	 * @brief ajout d'un commentaire
	 */
	public void addComment()
	{
		if(tempText != null && tempText != "" && !tempText.isEmpty())
		{
			Commentaire c = new Commentaire(tempText, LocalDateTime.now());
			tempText = "";
			orm.ajouterCommentaire(c);
			updateComments();
		}
	}
	
	/**
	 * @brief va à la prochaine page de commentaires
	 */
	public void nextPage()
	{
		if(allComments != null)
		{
			if(allComments.size() > (curPag)*10)
			{
				curPag++;
				currentPage++;
				updateComments();
			}
		}

	}
	
	/**
	 * @brief va à la page de commentaires précédente
	 */
	public void previousPage()
	{
		if(curPag > 1)
		{
			curPag--;
			currentPage--;
			updateComments();
		}
	}
	
	public Commentaire getComment(int ind)
	{
		return comments.get(ind);
	}
	public void setComment(Commentaire comment)
	{
		comments.add(comment);
	}

	public List<Commentaire> getComments()
	{
		return comments;
	}
	public void setComments(List<Commentaire> list)
	{
		this.comments = list;
	}

	public String getTempText() {
		return tempText;
	}
	public void setTempText(String tempText) {
		this.tempText = tempText;
	}

	public List<Commentaire> getTopComments() {
		return topComments;
	}
	public void setTopComments(List<Commentaire> topComments) {
		this.topComments = topComments;
	}

	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		CommentairesBean.currentPage = currentPage;
	}

	public List<Commentaire> getAllComments() {
		return allComments;
	}
	public void setAllComments(List<Commentaire> allComments) {
		this.allComments = allComments;
	}

	public int getCurPag() {
		return curPag;
	}

	public void setCurPag(int curPag) {
		this.curPag = curPag;
	}
}
