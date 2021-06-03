package entities;

import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.Transient;

@Entity(name="Commentaire")
public class Commentaire 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCommentaire;
	private String text;
	private LocalDateTime date;
	private int nombreJaime;
	
	@Transient
	private String showDate = "";
	
	public Commentaire()
	{
		
	}
	
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
	
	public void augmenterJaime()
	{
		nombreJaime++;
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
		calculateShowDate();
	}

	public int getNombreJaime() {
		return nombreJaime;
	}
	public void setNombreJaime(int nombreJaime) {
		this.nombreJaime = nombreJaime;
	}

	public String getShowDate() {
		return showDate;
	}
	public void setShowDate(String showDate) {
		this.showDate = showDate;
	}
}
