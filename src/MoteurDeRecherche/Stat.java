package MoteurDeRecherche;

public class Stat {
	private String mot;
	private int occ;
	private String fichier;
	public Stat(String mot,int occ,String fichier) {
		this.mot=mot;
		this.occ=occ;
		this.fichier=fichier;
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

	public String getFichier() {
		return this.fichier;
	}
	public void setFichier(String fichier) {
		this.fichier=fichier;
	}


}
