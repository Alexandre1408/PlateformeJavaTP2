package beans;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import entities.Membre;
import orm.MembreOrm;

import javax.faces.component.UIInput;

/***
 * Classe Beans pour l'inscription d'un nouveau membre
 *  
 * @author BELDA Tom, INGARAO Adrien, MAGGOUH Naoufal, UNG Alexandre
 *
 */

@Named
@RequestScoped
public class InscriptionBeans implements Serializable{
	private static final long serialVersionUID = 1L;
	/**
	 * Le nouveau membre inscrit
	 */
	private Membre membre;
	
	/**
	 * ORM pour ajouter à la base de données
	 */
	private MembreOrm orm;
	
	/**
	 * Constructeur
	 */
	public InscriptionBeans()
	{
		membre=new Membre();
		orm= new MembreOrm();
	}
	
	/**
	 * Inscrit le nouveau membre dans la base de données
	 */
    public void inscription() {
    	
        orm.ajouterMembre(membre);
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Succès","L'inscription a été validé");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    /**
     * 
     * @return le nouveau membre
     */
    public Membre getMembre()
    {
    	return membre;
    }
    
    /**
     * Vérifie si l'email est valide et n'existe pas déjà dans la base de données.
     * 
     * @param context
     * @param comp
     * @param value
     */
    public void validateEmail(FacesContext context, UIComponent comp, Object value)
    {
    	 String emailInput = (String) value;

         if (!emailInput.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) && emailInput != null) 
         {
             ((UIInput) comp).setValid(false);

             FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erreur","L'e-mail rentré n'est pas valide");
             context.addMessage(comp.getClientId(context), message);
         }
         
         if (!orm.mailDejaUtilise(emailInput))
         {
             ((UIInput) comp).setValid(false);

             FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erreur","L'e-mail rentré existe déjà");
             context.addMessage(comp.getClientId(context), message);
         }
    }
    
    /**
     * Vérifie si le mot de passe à au moins 3 caractères
     * 
     * @param context
     * @param comp
     * @param value
     */
    public void validatePassword(FacesContext context, UIComponent comp, Object value)
    {
    	 String passwordInput = (String) value;

         if (passwordInput.length() < 3) 
         {
             ((UIInput) comp).setValid(false);
             FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erreur","Le mot de passe doit contenir au moins 3 caractères");
             context.addMessage(comp.getClientId(context), message);
         }
    }
    
    /**
     * Vérifie si le prénom n'est pas vide
     * 
     * @param context
     * @param comp
     * @param value
     */
    public void validatePrenom(FacesContext context, UIComponent comp, Object value)
    {
    	String prenomInput = (String) value;
    	if(prenomInput.length() < 1)
    	{
    		((UIInput) comp).setValid(false);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erreur","Veuillez entrer un prénom");
            context.addMessage(comp.getClientId(context), message);
    	}
    }
    
    /**
     * Vérifie si le prénom n'est pas vide
     * 
     * @param context
     * @param comp
     * @param value
     */
    public void validateNom(FacesContext context, UIComponent comp, Object value)
    {
    	String nomInput = (String) value;
    	if(nomInput.length() < 1)
    	{
    		((UIInput) comp).setValid(false);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erreur","Veuillez entrer un nom");
            context.addMessage(comp.getClientId(context), message);
    	}
    }
}
