package MoteurDeRecherche;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
//import java.util.Map;

public class MoteurDeRecherche {
	public Index index;
	public MoteurDeRecherche(Index index) {
		this.index = index;
	}
	
	public void indexerUnDocument(String chemin) {
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
		
		Analyseur analyserFichier=new Analyseur();
		
		File file = new File(chemin);
        String nomFichier = file.getName();
        
		List<Stat> listeDesStat = new ArrayList<>();
		for(Stat stat : listeDesStat) {
			for(MotOcc motEtOcc : analyserFichier.analyser(fichier)) {
				stat = new Stat(motEtOcc.getMot(), motEtOcc.getOcc(), nomFichier);
				listeDesStat.add(stat);
			}
		}
		for(Stat stat : listeDesStat) {
			index.ajouterStat(stat);
		}
	}
	
	public List<Stat> rechercher(List<String> desMots,Index index){ 
//		//traitement de requette*************************
//		Nettoyage nettoyageDeMots=new Nettoyage();
//		Traiteur minuscule=new Minuscule();
//		Traiteur extracteur=new Extracteur();
//		List<String> RequetteFiltree=nettoyageDeMots.traiter(desMots);
//		RequetteFiltree=minuscule.traiter(RequetteFiltree);
//		RequetteFiltree=extracteur.traiter(RequetteFiltree);
//		System.out.println("********************************");
//		for(String mot : RequetteFiltree) {
//			System.out.println(mot);
//		}

		List<Stat> listeStat = index.getListStat();
		List<Stat> listDesStat = new ArrayList<Stat>();
		for(String mot : desMots) {
			for(Stat stat : listeStat) {
				if(stat.getMot().equals(mot)) {
					listDesStat.add(stat);
				}
			}
		}
		return listDesStat;
	}
}

