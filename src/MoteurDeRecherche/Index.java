package MoteurDeRecherche;

import java.util.List;
import java.util.ArrayList;

public class Index {
	private List<Stat> listeDesStat;
	public Index() {
		listeDesStat=new ArrayList<Stat>();
	}
	public List<Stat> getIndex(){
		return this.listeDesStat;
	}
	public List<Stat> getStatMot(String mot){
		List<Stat> result = new ArrayList<Stat>();
		for(Stat stat :listeDesStat) {
			if(stat.getMot().equals(mot))
				result.add(stat);
		}
		return result;
	}
	void ajouterStat(Stat stat) {
		listeDesStat.add(stat);
	}
	void removeFile(String chemin) {
		for(Stat stat : listeDesStat ) {
			if(stat.getChemin().equals(chemin)) 
				listeDesStat.remove(stat);
		}
	}

}
