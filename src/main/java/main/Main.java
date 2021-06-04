package main;


import entities.Commentaire;
import entities.Membre;
import orm.CommentaireOrm;
import orm.MainOrm;
import orm.MembreOrm;

public class Main 
{
	public static void main(String[] args) 
	{
		//MainOrm myOrm = new MainOrm();
		/*MembreOrm m = new MembreOrm();
		Membre membre = new Membre();
		membre.setNom("ssss");
		m.ajouterMembre(membre);*/
		CommentaireOrm cOrm = new CommentaireOrm();
		Commentaire c = new Commentaire();
		cOrm.ajouterCommentaire(c);
		//MyDao.aimerCommentaire(commentaire1);
	}
}
