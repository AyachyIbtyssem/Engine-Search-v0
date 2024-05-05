package MoteurDeRecherche;

import java.util.List;

public class Scoreur {
	
	public Scoreur() {}
	public double calculerScore(Stat stat) {
		double score;
		//determination de chemin de fichier a partir de stat 
		String folder = "C:/Users/MSI/eclipse-workspace/MiniProjet/src/petit_corpus/"; //voici chemin de mon dossier 
		List<String> fichier = stat.getContinueFichier(folder+stat.getNomFichier());
		
		score=(double)stat.getOcc()/(double)fichier.size();
		return score;
	}
	public double getScore(Stat stat) {
	       return calculerScore(stat);
	}
}