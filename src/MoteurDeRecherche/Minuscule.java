package MoteurDeRecherche;

import java.util.List;
import java.util.ArrayList;

public class Minuscule implements Traiteur{
		public Minuscule() {}
	    public List<String> traiter(List<String> listeMots) {
	        List<String> lowerCaseWords = new ArrayList<>();
	        for (String mot : listeMots) {
	            lowerCaseWords.add(mot.toLowerCase());
	        }
	        return lowerCaseWords;
	    }

}