package MoteurDeRecherche;

import java.util.ArrayList;
import java.util.List;

public class MainProjet{

	public static void main(String[] args) {
		List<String> mots = new ArrayList<>();
		mots.add("Hello!!!");
		mots.add("de");
		mots.add("machine learning?");
		mots.add("mlops is important#");
		mots.add("devops");
		mots.add("I AM EXCITED TO SEE U");
		mots.add(" !!!hello gys ##");
		
		Nettoyage nettoyageDeMots=new Nettoyage();
		List<String> importantWords=nettoyageDeMots.traiter(mots);
		System.out.println("********************************");
		System.out.println("this is the list of important word");
		for(String mot:importantWords) {
			System.out.println(mot);
		}
		
		Traiteur minuscule=new Minuscule();
		importantWords=minuscule.traiter(importantWords);
		System.out.println("********************************");
		System.out.println("this is the list of lowcase words");
		for(String mot:importantWords) {
			System.out.println(mot);
		}
		
		Traiteur extracteur=new Extracteur();
		importantWords=extracteur.traiter(importantWords);
		System.out.println("********************************");
		System.out.println("this is the list of extractor word");
		for(String mot:importantWords) {
			System.out.println(mot);
		}
	}
}