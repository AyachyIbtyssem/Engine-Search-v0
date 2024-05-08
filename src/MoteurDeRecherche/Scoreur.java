package MoteurDeRecherche;

import java.util.List;

public class Scoreur {
	public double calculerScore(List<Stat> statFichier) {
		double score=0;
		for(Stat stat : statFichier) {
			score+=stat.getOcc();
		}
		return score;
	}
}