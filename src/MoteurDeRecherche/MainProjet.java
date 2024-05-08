package MoteurDeRecherche;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
//import java.util.Scanner;
//import java.io.File;
import java.util.Map;

public class MainProjet{

	public static void main(String[] args) {
		

		MoteurDeRecherche moteur = new MoteurDeRecherche();
		String chemin = "C:/Users/MSI/eclipse-workspace/MiniProjet/src/petit_corpus";
		moteur.index(chemin);
        
		List<String> fichier = new ArrayList<>();
		LecteurMotParMot motParMot=new LecteurMotParMot();
		fichier=motParMot.lire(chemin);
		
		//traiter fichier
		Nettoyage nettoyageDeMots=new Nettoyage();
		List<String> importantWords=nettoyageDeMots.traiter(fichier);
		Traiteur minuscule=new Minuscule();
		importantWords=minuscule.traiter(importantWords);
		Traiteur extracteur=new Extracteur();
		importantWords=extracteur.traiter(importantWords);
		System.out.println(importantWords);
		
		String requette = "java project ";
		
//		//traiter requette
//		List<String> importantrequette=nettoyageDeMots.traiter(desMots);
//		importantrequette=minuscule.traiter(importantrequette);
//		importantrequette=extracteur.traiter(importantrequette);
//		System.out.println(importantrequette);
		
		Analyseur1 analyseFichier = new Analyseur1();
		List<MotOcc> listeMotOcc= analyseFichier.analyser(importantWords);
		System.out.println("voici la liste des MotOcc");
		for(MotOcc motEtOcc : listeMotOcc) {
			System.out.println(motEtOcc.toString());
		}
		
		File file = new File(chemin);
        String nomFichier = file.getName();	
		List<Stat> listStat = new ArrayList<Stat>();
		for(MotOcc motEtOcc : listeMotOcc) {
			listStat.add(new Stat(motEtOcc.getMot(), motEtOcc.getOcc(), nomFichier));
		}
		
		//afficher liste des stat 
//		System.out.println("voici la liste des stat");
//		for(Stat stat : listStat) {
//			System.out.println(stat.toString());
//		}
		
		//calcule score 
		List<Double> listScores = new ArrayList<Double>();
		Scoreur scoreur = new Scoreur();
		for(Stat stat : listStat) {
			listScores.add(scoreur.calculerScore(stat));
			
		}
//		for(Double score : listScores) {
//			System.out.println(score);
//		}
//		
//		//tri score et affichage
//		TriScore ordonnanceur = new TriScore();
//		Map<String, Double> fichierScore = ordonnanceur.ordonnerScores(listStat);
//		for (Map.Entry<String, Double> entry : fichierScore.entrySet()) {
//            String mafichier = entry.getKey();
//            Double score = entry.getValue();
//            System.out.println("Fichier: " + mafichier + ", Score: " + score);
//        }
//		Index index = new Index(listStat);
//		MoteurDeRecherche moteur = new MoteurDeRecherche();
//		for(Stat stat : moteur.rechercher(importantrequette, index)) {
//			System.out.println(stat.toString());
//		}
		
		
//		String folder = "C:/Users/MSI/eclipse-workspace/MiniProjet/src/petit_corpus/";
//		File directory = new File(folder);
//		if (directory.exists() && directory.isDirectory()) {
//			 File[] files = directory.listFiles();
//			 
//	        if (files != null) {
//	            for (File file : files) {
//	                if (file.isFile()) {
//	                    System.out.println(folder + file.getName());
//	                    chemin = folder + file.getName();
//	                    System.out.println(chemin);
//	                    
//	                }
//	            }
//	        }
//		}
	}
}


