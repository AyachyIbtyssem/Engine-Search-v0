package MoteurDeRecherche;


public class Scoreur {
	Index index;
	public Scoreur() {}
	public double calculerScore(Stat stat) {
		double score;
		score=stat.getOcc()/stat.getFichier().length();
		return score;
	}
	public double getScore(Stat stat) {
	       return calculerScore(stat);
	}
}