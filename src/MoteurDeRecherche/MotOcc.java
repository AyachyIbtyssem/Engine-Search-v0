package MoteurDeRecherche;

public class MotOcc {
	private String mot;
	private int occ;
	public MotOcc(String mot,int occ) {
		this.mot=mot;
		this.occ=occ;
	}
	public String getMot() {
		return mot;
	}
	public int getOcc() {
		return occ;
	}
	public void incrementer() {
		occ=+1;
	}
	public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ mot: ").append(mot)
          .append(", occ: ").append(occ)
          .append("]").append("\n");
        return sb.toString();
    }


	


}