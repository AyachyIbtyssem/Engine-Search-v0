package MoteurDeRecherche;

import java.util.ArrayList;
import java.util.List;

public class Stat {
	private String mot;
	private int occ;
	private String NomFichier;
	public Stat(String mot,int occ,String NomFichier) {
		this.mot=mot;
		this.occ=occ;
		this.NomFichier=NomFichier;
	}
	public String getMot() {
		return this.mot;
	}
	public void setMot(String mot) {
		this.mot=mot;
	}
	public int getOcc() {
		return this.occ;
	}
	public void setOcc(int occ) {
		this.occ=occ;
	}

	public String getNomFichier() {
		return this.NomFichier;
	}
	public void setNomFichier(String NomFichier) {
		this.NomFichier=NomFichier;
	}
	public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ mot: ").append(getMot())
          .append(", occ: ").append(getOcc())
          .append(", fichier: ").append(getNomFichier())
          .append("]").append("\n");
        return sb.toString();
    }
	
	public List<String> getContinueFichier(String chemin){
		LecteurMotParMot motParMot=new LecteurMotParMot();
		List<String> fichier = new ArrayList<>();
		fichier=motParMot.lire(chemin);
		return fichier;
	}


}
