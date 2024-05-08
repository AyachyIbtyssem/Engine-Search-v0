package MoteurDeRecherche;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
//import java.util.Map;

public class MoteurDeRecherche {
	Index index;
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
    	LecteurMotParMot motParMot=new LecteurMotParMot();
    	List<String> file = new ArrayList<String>();
    	file = motParMot.lire(path);
    	List<MotOcc> listMotOcc = new ArrayList<MotOcc>();
    	listMotOcc = Analyseur1.analyser(file);
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
    }
	public List<Stat> rechercher(List<String> requette){ 
		List<Stat> listDesStat = new ArrayList<Stat>();
		for(String mot : requette) {
			for(Stat stat : index.getIndex()) {
				if(stat.getMot().equals(mot)) {
					listDesStat.add(stat);
				}
			}
		}
		return listDesStat;
	}
}

