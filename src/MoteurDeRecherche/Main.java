package MoteurDeRecherche;

import java.util.List;
import java.util.ArrayList;


public class Main{

	public static void main(String[] args) {
		
		LecteurMotParMot lecteur = new LecteurMotParMot();
		Analyseur analyseur=new Analyseur1();
		List<Traiteur> listTraiteur = new ArrayList<Traiteur>();
		Nettoyage nettoyage = new Nettoyage();
		Extracteur extracteur = new Extracteur();
		Minuscule minuscule = new Minuscule();
		listTraiteur.add(nettoyage);
		listTraiteur.add(extracteur);
		listTraiteur.add(minuscule);
		
		Index index = new Index();
		
		MoteurDeRecherche moteur = new MoteurDeRecherche(index,listTraiteur,lecteur,analyseur);
		String chemin ="C:/Users/MSI/eclipse-workspace/MiniProjet/src/tres_petit_corpus";
		moteur.index(chemin);
		
		for(Stat stat : index.getIndex()) {
			stat.toString();
		}
		List<String> requete = new ArrayList<String>();
		requete.add("right");
		requete.add("convention");
		System.out.println("voici la liste stat"+moteur.rechercher(requete));


		
	}

		

}