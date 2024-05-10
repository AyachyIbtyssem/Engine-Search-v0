package MoteurDeRecherche;

import java.util.List;
import java.util.ArrayList;

public class Extracteur implements Traiteur{
	
		public Extracteur() {}
	    public List<String> traiter(List<String> listeMots) {
	        List<String> cleanWords = new ArrayList<>();
	        for (String mot : listeMots) {
	            String cleanWord = mot.replaceAll("[^a-zA-Z]", "");
	            cleanWords.add(cleanWord);
	        }
	        return cleanWords;
	    }

}