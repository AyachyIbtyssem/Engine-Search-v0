package MoteurDeRecherche;


public class Stat {
	private String mot;
	private int occ;
	private String chemin;
	public Stat(String mot,int occ,String chemin) {
		this.mot=mot;
		this.occ=occ;
		this.chemin=chemin;
	}
	public String getMot() {
		return this.mot;
	}
	public int getOcc() {
		return this.occ;
	}
	public String getChemin() {
		return this.chemin;
	}
	public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ mot: ").append(mot)
          .append(", occ: ").append(occ)
          .append(", fichier: ").append(chemin)
          .append("]").append("\n");
        return sb.toString();
    }

}
