package entities;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.Transient;

/**
 * Classe entity qui représente un commentaire laissé sur le site
 * @author BELDA Tom, INGARAO Adrien, MAGGOUH Naoufal, UNG Alexandre
 *
 */
@Entity(name="Commentaire")
public class Commentaire 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	/**
	 * L'id du commentaire
	 */
	private int idCommentaire;
	
	/**
	 * Le texte du commentaire
	 */
	private String text;
	
	/**
	 * La date à laquelle le commentaire a été publié
	 */
	private LocalDateTime date;
	
	/**
	 * L enombre de j'aime associés au commentaire
	 */
	private int nombreJaime;
	
	/**
	 * La date à afficher sous le commentaire
	 */
	@Transient
	private String showDate = "";
	
	/**
	 * Constructeur par défaut
	 */
	public Commentaire()
	{
		
	}
	
	/**
	 * Constructeur de la classe commentaire
	 * @param text Le texte du commentaire
	 * @param date la date et l'heure à laquelle le commentaire a été créé
	 */
	public Commentaire(String text, LocalDateTime date)
	{
		this.text = text;
		this.date = date;
		nombreJaime = 0;
		calculateShowDate();
	}
	
	
	@PostLoad
	protected void initShowDate() {
		calculateShowDate();
	}
	
	/**
	 * Calcule la date ou le message à afficher sous un commentaire
	 */
	private void calculateShowDate()
	{
		long years = ChronoUnit.YEARS.between(date, LocalDateTime.now());
		long months = ChronoUnit.MONTHS.between(date, LocalDateTime.now());
        long weeks = ChronoUnit.WEEKS.between(date, LocalDateTime.now());
        long days = ChronoUnit.DAYS.between(date, LocalDateTime.now());
        long hours = ChronoUnit.HOURS.between(date, LocalDateTime.now());
        long minutes = ChronoUnit.MINUTES.between(date, LocalDateTime.now());

		if(years > 1)
			showDate = "Il y a " +years +" ans";
		else if(years == 1)
			showDate = "Il y a 1 an";
		else if(months >= 1)
			showDate = "Il y a " +months +" mois";
		else if(weeks > 1)
			showDate = "Il y a " +weeks +" semaines";
		else if(weeks == 1)
			showDate = "Il y a 1 semaine";
		else if(days > 1)
			showDate = "Il y a " +days +" jours";
		else if(days == 1)
			showDate = "Il y a 1 jour";
		else if(hours > 1)
			showDate = "Il y a " +hours +" heures";
		else if(hours == 1)
			showDate = "Il y a 1 heure";
		else if(minutes > 1)
			showDate = "Il y a " +minutes +" minutes";
		else if(minutes == 1)
			showDate = "Il y a 1 minute";
		else
			showDate = "Il y a moins d'une minute";
	}
	
	/*
	 * Incrémente le nombre de j'aime d'un commentaire
	 */
	public void augmenterJaime()
	{
		nombreJaime++;
	}
	
	/**
	 * Retourne l'id du commentaire
	 * @return l'id du commentaire
	 */
	public int getIdCommentaire() {
		return idCommentaire;
	}
	
	/**
	 * Retourne le message du commentaire
	 * @return le texte du commentaire
	 */
	public String getText() {
		return text;
	}
	
	/**
	 * Change le texte du commentaire
	 * @param text le nouveau texte
	 */
	public void setText(String text) {
		this.text = text;
	}
	
	/**
	 * Retourne la date du commentaire
	 * @return
	 */
	public LocalDateTime getDate() {
		return date;
	}
	
	/**
	 * Change la date du commentaire
	 * @param date la nouvelle date
	 */
	public void setDate(LocalDateTime date) {
		this.date = date;
		calculateShowDate();
	}
	
	/**
	 * Retourne le nombre de j'aime du commentaire
	 * @return 
	 */
	public int getNombreJaime() {
		return nombreJaime;
	}
	
	/**
	 * Change le nombre de j'aime du commentaire
	 * @param nombreJaime le nouveau nombre de j'aime
	 */
	public void setNombreJaime(int nombreJaime) {
		this.nombreJaime = nombreJaime;
	}
	
	/**
	 * Retourne la date à afficher sous le commentaire
	 * @return la date
	 */
	public String getShowDate() {
		return showDate;
	}
	
	/**
	 * Change la date du commentaire
	 * @param showDate la nouvelle date
	 */
	public void setShowDate(String showDate) {
		this.showDate = showDate;
	}
}
