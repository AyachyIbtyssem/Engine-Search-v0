package MoteurDeRecherche;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;
//import java.util.ArrayList;
import java.util.Comparator;

public class TriScore {
    
    public Map<String, Double> ordonnerScores(List<Stat> listStat) {
    	Map<String, Double> FichierScore = new HashMap<>();
    	for(Stat stat : listStat) {
    		//String chemin = "C:/Users/MSI/eclipse-workspace/MiniProjet/src/petit_corpus/"+stat.getFichier();
    		//LecteurMotParMot motParMot=new LecteurMotParMot();
    		//List<String> fichier = new ArrayList<>();
    		//fichier=motParMot.lire(chemin);
    		
    		FichierScore.put(stat.getNomFichier(),new Scoreur().calculerScore(stat));
    	}
    	return FichierScore.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, HashMap::new));
    }
}