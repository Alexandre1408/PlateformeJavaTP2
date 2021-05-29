package entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 * \brief classe des utilisateurs du modèle qui permettront de générer la base de données
 * à partir des annotations d'hibernate présentes dans la classe.
 * @version 1.0
 * @author Sean Anica, Alhabaj Mahmod et Rondeau Juliette
 *
 */

@Entity(name="User")
public class User
{
	//Attributs de la classe
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUser;
	
	private String pseudo;
	

	private String password;
	
	private String name;
	
	private String firstname;
	
	private String address;
	
	private String mail;
		
	
	/**
	 * constructeur par défaut
	 */
	public User() {
		super();
	}
	
	/**
	 * constructeur de confort qui permet d'initialiser tous les attributs de la classe.
	 * @param pseudo
	 * @param password
	 * @param name
	 * @param firstname
	 * @param address
	 * @param mail
	 */
	public User(String pseudo, String password, String name, String firstname, String address, String mail) {
		super();
		this.name = name;
		this.firstname = firstname;
		this.address = address;
		this.mail = mail;
		this.pseudo = pseudo;
		this.password = password;
	}
	
	/**
	 * constructeur de confort qui permet d'initialiser les attributs pseudo et mot de passe de la classe.
	 * @param pseudo
	 * @param password
	 */
	public User(String pseudo, String password) 
	{
		super();
		this.pseudo = pseudo;
		this.password = password;
	}

	/***********************************GETTERS ET SETTERS DES ATTRIBUTS****************************************/
	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	/****************************************************************************************************/

	/**
	 * redéfinition de la méthode toString de la classe User.
	 * 
	 *@return affichageUser : String
	 */
	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", pseudo=" + pseudo + ", password=" + password + ", name=" + name
				+ ", firstname=" + firstname + ", address=" + address + ", mail=" + mail + "]";
	}
	
	
}
