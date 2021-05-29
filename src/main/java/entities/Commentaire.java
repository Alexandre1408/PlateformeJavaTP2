package entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="Commentaire")
public class Commentaire 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCommentaire;
	private String text;
	private LocalDateTime date;
	
	public Commentaire()
	{
		
	}
	
	public Commentaire(String text, LocalDateTime date)
	{
		this.text = text;
		this.date = date;
	}
	
	public int getIdCommentaire() {
		return idCommentaire;
	}

	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	
	
}
