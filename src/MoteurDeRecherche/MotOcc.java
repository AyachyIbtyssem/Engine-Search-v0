package MoteurDeRecherche;

public class MotOcc {
	private String mot;
	private int occ;
	public MotOcc(String mot,int occ) {
		this.mot=mot;
		this.occ=occ;
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



}