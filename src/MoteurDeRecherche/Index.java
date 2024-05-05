package MoteurDeRecherche;

import java.util.List;

public class Index {
	private List<Stat> listeDesStat;
	public Index(List<Stat> listeDesStat) {
		this.listeDesStat = listeDesStat;
	}
	
	public List<Stat> getListStat(){
		return this.listeDesStat;
	}
	public Stat getStatMot(String mot){
		for(Stat stat :listeDesStat) {
			if(stat.getMot().equals(mot))
				return stat;
		}
		return null;
	}
	public void ajouterStat(Stat stat) {
		listeDesStat.add(stat);
	}

}
