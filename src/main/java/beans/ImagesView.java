package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * Classe utilisée pour afficher les images du contentFlow (les joueurs formés par nous-même)
 * @author BELDA Tom, INGARAO Adrien, MAGGOUH Naoufal, UNG Alexandre
 */
@Named
@RequestScoped
public class ImagesView implements Serializable
{
	/**
	 * Utilisé car la classe implement serializable
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Liste des images qui seront affichées dans le contentFlow
	 */
	private List<String> images;
	
	/**
	 * Initialise les données de la liste
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
     * Getter de la liste des noms des images à afficher
     * @return la liste des noms des images à afficher
     */
    public List<String> getImages()
    {
        return images;
    }
}