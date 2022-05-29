package classes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Materiels {
    
    public ArrayList GetListe() throws IOException{
        ArrayList MaterielsListe = new ArrayList<>();
        String txt = new String(Files.readAllBytes(Paths.get("src/ressources/liste.txt")));
        
        
        return MaterielsListe;
    }
}
