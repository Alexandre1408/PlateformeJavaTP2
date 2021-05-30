package entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity(name="Member")
public class Member
{
	//Attributs de la classe
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMember;
	
	private String motDePasse;
	
	private String nom;
	
	private String prenom;
	
	private String mail;
	
		
	public Member()
	{
		
	}
	
	public Member(String nom,String prenom,String motDePasse,String mail)
	{
		this.nom = nom;
		this.prenom = prenom;
		this.motDePasse = motDePasse;
		this.mail = mail;
	}
	

	public int getIdMember() 
	{
		return idMember;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public String toString() {
		return "Member [idMember=" + idMember + ", motDePasse=" + motDePasse + ", nom=" + nom + ", prenom=" + prenom
				+ ", mail=" + mail + "]";
	}

	
}
