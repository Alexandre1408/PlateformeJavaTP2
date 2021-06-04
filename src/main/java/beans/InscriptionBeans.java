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


@Named
@RequestScoped
public class InscriptionBeans implements Serializable{
	private static final long serialVersionUID = 1L;
	private Membre membre;
	
	private MembreOrm orm;
	
	public InscriptionBeans()
	{
		membre=new Membre();
		orm= new MembreOrm();
	}
	
    public void inscription() {
    	
        orm.ajouterMembre(membre);
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Succès","L'inscription a été validé");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public Membre getMembre()
    {
    	return membre;
    }
    
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
