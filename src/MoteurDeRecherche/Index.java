package MoteurDeRecherche;

import java.util.List;

public class Index {
	private List<Stat> listeDesStat;
	public Index() {}
	public Stat getStatMot(){
		for(Stat stat :listeDesStat) {
				return stat;
		}
		return null;
	}
	public void ajouterStat(Stat stat) {
		listeDesStat.add(stat);
	}

}
