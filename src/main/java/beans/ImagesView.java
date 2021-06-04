package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


@Named
@RequestScoped
public class ImagesView implements Serializable
{
	private static final long serialVersionUID = 1L;
	private List<String> images;

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

    public List<String> getImages()
    {
        return images;
    }
}