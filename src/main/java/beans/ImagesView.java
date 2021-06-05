package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * Classe utilis�e pour afficher les images du contentFlow (les joueurs form�s par nous-m�me)
 * @author BELDA Tom, INGARAO Adrien, MAGGOUH Naoufal, UNG Alexandre
 */
@Named
@RequestScoped
public class ImagesView implements Serializable
{
	/**
	 * Utilis� car la classe implement serializable
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Liste des images qui seront affich�es dans le contentFlow
	 */
	private List<String> images;
	
	/**
	 * Initialise les donn�es de la liste
	 */
    @PostConstruct
    public void init()
    {
        images = new ArrayList<String>();
        images.add("Faker");
        images.add("Caps");
        images.add("TenZ");
        images.add("Bikinibodhi");
        images.add("ZywOo");
    }
    
    /**
     * Getter de la liste des noms des images � afficher
     * @return la liste des noms des images � afficher
     */
    public List<String> getImages()
    {
        return images;
    }
}