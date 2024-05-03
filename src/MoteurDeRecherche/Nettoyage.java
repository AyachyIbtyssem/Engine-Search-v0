package MoteurDeRecherche;

import java.util.List;
import java.util.ArrayList;

public class Nettoyage implements Traiteur {
	   
	   public Nettoyage() {}
	   @Override
	    public List<String> traiter(List<String> listeMots) {
	        List<String> importantWords = new ArrayList<>();
	        for (String mot : listeMots) {
	            if (!isUnimportantWord(mot)) {
	                importantWords.add(mot);
	            }
	        }
	        return importantWords;
	    }
	   private boolean isUnimportantWord(String word) {
	        String[] unimportantWords = {"le", "la", "l'","de",
	        		"pour", "comme", "et", "est", "c'est" ,"quand","avec","are","is","this","that"};
	        for (String unimportantWord : unimportantWords) {
	            if (word.equalsIgnoreCase(unimportantWord)) {
	                return true;
	            }
	        }
	        return false;
	    }

}