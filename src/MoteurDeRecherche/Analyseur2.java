package MoteurDeRecherche;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;


public class Analyseur2  implements Analyseur{
	public List<MotOcc> analyser( List<String> listeMots){
		Map<String, Integer> comptages = new HashMap<>();
		List<MotOcc> motEtOcc = new ArrayList<MotOcc>();
		for(String mot : listeMots) {
			Integer n=comptages.get(mot);
			if(n == null)
				comptages.put(mot, 1);
			else 
				comptages.put(mot, n+1);
		}
		for (Map.Entry<String, Integer> entry : comptages.entrySet()) {
		    String key = entry.getKey();
		    Integer value = entry.getValue();
		    motEtOcc.add(new MotOcc(key,value));
		}
		return motEtOcc;
	}
	
}
