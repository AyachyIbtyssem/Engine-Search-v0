package MoteurDeRecherche;


import java.util.*;

public class TriScore {
    
	public Map<String, Double> ordonnerScores(Map<String, Double> cheminScore) {

        List<Map.Entry<String, Double>> list = new LinkedList<>(cheminScore.entrySet());
        list.sort(Map.Entry.comparingByValue());
        Map<String, Double> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Double> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }
}