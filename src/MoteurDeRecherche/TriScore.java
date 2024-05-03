package MoteurDeRecherche;

import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class TriScore {
    public List<Scoreur> listeDesScores;

    public TriScore(List<Scoreur> listeDesScores) {
        this.listeDesScores = listeDesScores;
    }

    public List<Scoreur> ordonnerScores(List<Index> listeDesIndex) {
    	for(Index index:listeDesIndex) {
    		Collections.sort(listeDesScores, new Comparator<Scoreur>() {
    			@Override
    			public int compare(Scoreur scoreur1, Scoreur scoreur2) {
    				double score1 = scoreur1.calculerScore(index.getStatMot());
    				double score2 = scoreur2.calculerScore(index.getStatMot());
    				return Double.compare(score1, score2);
    			}
    		});

    		return listeDesScores;
    	}
    	return null;
    }
}