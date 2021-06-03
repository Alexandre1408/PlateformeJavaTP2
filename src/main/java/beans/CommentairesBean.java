package beans;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import entities.Commentaire;
import orm.CommentaireOrm;

@ManagedBean
@RequestScoped
public class CommentairesBean implements Serializable {

	private static final long serialVersionUID = 3199686126907808648L;

	private CommentaireOrm orm;
	private List<Commentaire> topComments;
	private List<Commentaire> comments;
	
	private String tempText;
    
	@PostConstruct
    public void init(){
		orm = new CommentaireOrm();
		topComments = orm.trouverTopCommentaireLimiter(3);
		comments = orm.trouverTousCommentaireLimiter(10);
    }
	
	public void likeComment(int id)
	{
		for(Commentaire comment : comments)
		{
			if(comment.getIdCommentaire() == id)
				orm.aimerCommentaire(comment);
		}
	}
	
	public void addComment()
	{
		Commentaire c = new Commentaire(tempText, LocalDateTime.now());
		tempText = "";
		orm.ajouterCommentaire(c);
		if(comments.size() == 10)
			comments.remove(9);
		comments.add(0, c);
	}
	
	public Commentaire getComment(int ind)
	{
		return comments.get(ind);
	}

	public List<Commentaire> getComments()
	{
		return comments;
	}
	public void setComment(Commentaire comment)
	{
		comments.add(comment);
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
}
