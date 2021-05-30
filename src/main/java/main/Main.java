package main;

import java.util.List;

import entities.Commentaire;
import entities.Membre;
import orm.MainOrm;

public class Main 
{
	public static void main(String[] args) 
	{
		MainOrm myOrm = new MainOrm();
		//Membre a =  new Membre();
		Membre Membre1 = new Membre();
		Membre Membre2 = new Membre();
		Membre Membre3 = new Membre();
		Membre Membre4 = new Membre();
		Membre Membre5 = new Membre();
		Membre Membre6 = new Membre();
		
		/*MyDao.ajouterMembre(a);
		MyDao.supprimerMembre(a);*/
		myOrm.ajouterMembre(Membre1);
		myOrm.ajouterMembre(Membre2);
		myOrm.ajouterMembre(Membre3);
		myOrm.ajouterMembre(Membre4);
		myOrm.ajouterMembre(Membre5);
		myOrm.ajouterMembre(Membre6);


		List<Commentaire> L1 = myOrm.trouverTopCommentaireLimiter(2);
		List<Membre> M1 = myOrm.trouverTousLesMembres();


		//MyDao.aimerCommentaire(commentaire1);
	}
}
