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
	 * ORM pour ajouter � la base de donn�es
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
	 * Inscrit le nouveau membre dans la base de donn�es
	 */
    public void inscription() {
    	
        orm.ajouterMembre(membre);
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Succ�s","L'inscription a �t� valid�");
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
     * V�rifie si l'email est valide et n'existe pas d�j� dans la base de donn�es.
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

             FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erreur","L'e-mail rentr� n'est pas valide");
             context.addMessage(comp.getClientId(context), message);
         }
         
         if (!orm.mailDejaUtilise(emailInput))
         {
             ((UIInput) comp).setValid(false);

             FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erreur","L'e-mail rentr� existe d�j�");
             context.addMessage(comp.getClientId(context), message);
         }
    }
    
    /**
     * V�rifie si le mot de passe � au moins 3 caract�res
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
             FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erreur","Le mot de passe doit contenir au moins 3 caract�res");
             context.addMessage(comp.getClientId(context), message);
         }
    }
    
    /**
     * V�rifie si le pr�nom n'est pas vide
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
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erreur","Veuillez entrer un pr�nom");
            context.addMessage(comp.getClientId(context), message);
    	}
    }
    
    /**
     * V�rifie si le pr�nom n'est pas vide
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
