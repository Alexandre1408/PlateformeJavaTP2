package entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Classe Entity pour un membre
 * 
 * @author BELDA Tom, INGARAO Adrien, MAGGOUH Naoufal, UNG Alexandre-
 *
 */
@Entity(name="Membre")
public class Membre
{
	/**
	 * Id du membre
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMember;
	
	/**
	 * Mot de passe du membre
	 */
	private String motDePasse;
	
	/**
	 * Nom du membre
	 */
	private String nom;
	
	/**
	 * Pr�nom du membre
	 */
	private String prenom;
	
	/**
	 * Email du membre
	 */
	private String mail;
	
		
	/**
	 * Constructeur par d�faut
	 */
	public Membre()
	{
		
	}
	
	/**
	 * Constructeur de membre
	 * 
	 * @param nom
	 * @param prenom
	 * @param motDePasse
	 * @param mail
	 */
	public Membre(String nom,String prenom,String motDePasse,String mail)
	{
		this.nom = nom;
		this.prenom = prenom;
		this.motDePasse = motDePasse;
		this.mail = mail;
	}
	
	/**
	 * 
	 * @return l'id du membre
	 */
	public int getIdMember() 
	{
		return idMember;
	}

	/**
	 * 
	 * @return le mot de passe du membre
	 */
	public String getMotDePasse() {
		return motDePasse;
	}

	/**
	 * Met � jour le mot de passe
	 * 
	 * @param motDePasse
	 */
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	/**
	 * 
	 * @return le nom du membre
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Met � jour le nom du membre
	 * 
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * 
	 * @return le pr�nom du membre
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * Met � jour le pr�nom du membre
	 * 
	 * @param prenom
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * 
	 * @return le mail du membre
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * Met � jour le mail du membre
	 * 
	 * @param mail
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * Surcharche de la m�thode toString
	 */
	@Override
	public String toString() {
		return "Member [idMember=" + idMember + ", motDePasse=" + motDePasse + ", nom=" + nom + ", prenom=" + prenom
				+ ", mail=" + mail + "]";
	}

	
}
