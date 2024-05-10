package MoteurDeRecherche;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
//import java.util.Map;

public class MoteurDeRecherche {

	Index index ;
	List<Traiteur> listTraiteur;
	LecteurMotParMot lecteur;
	Analyseur analyseur;

	public MoteurDeRecherche(Index index,List<Traiteur> listTraiteur,LecteurMotParMot lecteur,Analyseur analyseur) {
		this.index=index;
		this.listTraiteur=listTraiteur;
		this.lecteur=lecteur;
		this.analyseur=analyseur;
	}
	
	private void indexDirectory(String path){
        File pathFile = Paths.get(path).toFile();
        File[] files = pathFile.listFiles();
        for(File f: files ){
            if(f.isDirectory()){
                indexDirectory(f.getAbsolutePath());
            }else{
                indexSingleDocument(f.getAbsolutePath());
            }
        }
    }
	
    private void indexSingleDocument(String path){
    	List<String> file = new ArrayList<String>();
		file = lecteur.lire(path);
		List<String> fileTraite = file;
		
		for(Traiteur traiteur : listTraiteur) {
			fileTraite=traiteur.traiter(fileTraite);
		}
		
		List<MotOcc> listMotOcc = new ArrayList<MotOcc>();
		listMotOcc = analyseur.analyser(fileTraite);
		for(MotOcc m : listMotOcc) {
			index.ajouterStat(new Stat(m.getMot(),m.getOcc(), path));
		}
    }
    public void index(String path){
        File filePath = Paths.get(path).toFile();
        if(filePath.exists()){
            if(filePath.isDirectory()){
                indexDirectory(path);
            }else{
                indexSingleDocument(path);
            }
        }
        System.out.println(index.getIndex());
    }
	public List<Stat> rechercher(List<String> requete){ 
		List<Stat> listDesStat = new ArrayList<Stat>();
		List<String> requeteTraitee = requete;

		for(Traiteur traiteur : listTraiteur) {
			requeteTraitee=traiteur.traiter(requeteTraitee);
		}
		
		for(String mot : requeteTraitee) {
			for(Stat stat : index.getIndex()) {
				if(stat.getMot().equals(mot)) {
					listDesStat.add(stat);
				}
			}
		}
		return listDesStat;
	}
}

