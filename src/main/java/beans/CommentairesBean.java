package beans;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import entities.Commentaire;
import orm.CommentaireOrm;

@ManagedBean
@RequestScoped
public class CommentairesBean implements Serializable {

	private static final long serialVersionUID = 3199686126907808648L;

	private static int currentPage = 1;

	private CommentaireOrm orm;
	private List<Commentaire> topComments;
	private List<Commentaire> comments;
	private List<Commentaire> allComments;
	
	private int curPag;
	
	private String tempText;
    
	@PostConstruct
    public void init(){
		orm = new CommentaireOrm();
		setCurPag(currentPage);
		updateComments();
    }
	
	public void updateComments()
	{
		setTopComments(orm.trouverTopCommentaireLimiter(3));
		setAllComments(orm.trouverTousCommentaire());
		initPageComments();
	}
	
	public void initPageComments()
	{
		if(allComments.size() >= (curPag*10))
			setComments(allComments.subList((curPag-1)*10, (curPag*10)));
		else
		{
			setComments(allComments.subList((curPag-1)*10, allComments.size()));
		}
	}
	
	public void likeComment(int id)
	{
		for(int ind = 0; ind < allComments.size(); ind++)
		{
			if(allComments.get(ind).getIdCommentaire() == id)
				orm.aimerCommentaire(allComments.get(ind));
			updateComments();
		}
	}
	
	public void addComment()
	{
		Commentaire c = new Commentaire(tempText, LocalDateTime.now());
		tempText = "";
		orm.ajouterCommentaire(c);
		updateComments();
	}
	
	public void nextPage()
	{
		if(allComments.size() > (curPag)*10)
		{
			curPag++;
			currentPage++;
			updateComments();
		}
	}
	
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
