package gosecuri;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class Agent {

    String Subname;
    String Name;
    String Firstname;
    String mission;
    String password;
    ArrayList<String> Tools;

    public void GetAgentInfos(String name, Map<String, String> Tools_List) throws IOException {
        BufferedReader b = new BufferedReader(new FileReader("target/ressources/fiches_agents/" + name + ".txt"));
        String str;
        int i = 0;
        Tools = new ArrayList<>();
        this.Subname = name;
        while ((str = b.readLine()) != null) {
            switch (i) {
                case 0:
                    this.Name = str;
                    break;
                case 1:
                    this.Firstname = str;
                    break;
                case 2:
                    this.mission = str;
                    break;
                case 3:
                    this.password = str;
                    break;
                default:
                    this.Tools.add("`" + Tools_List.get(str) + "`");
                    break;
            }
            i++;
        }
        b.close();
    }

    public void WriteHTML() throws IOException {
        String HTML = "<!DOCTYPE html>\n<html lang='en'>\n<head>\n<meta charset='UTF-8'>\n<meta http-equiv='X-UA-Compatible' content='IE=edge'>\n<meta name='viewport' content='width=device-width, initial-scale=1.0'>\n<link rel='stylesheet' href='style.css'>\n</head>\n<body>\n<h1 class='name' id='name'></h1>\n<h2 class='mission' id='mission'></h2>\n<ul class='props' id='props'></ul>\n<img src='' id='identity_card' class='identity_card'>\n<script>\nconst Nom = '" + this.Name + "';\nconst Prenom = '" + this.Firstname + "';\nconst Mission = '" + this.mission + "';\nconst htpassword = '" + this.password + "';\nconst Materiaux = " + this.Tools + "; // ['tazer', 'matraque', 'plaque']\ndocument.title = Prenom + ' ' + Nom;\ndocument.getElementById('name').innerHTML = Prenom + ' ' + Nom;\ndocument.getElementById('mission').innerHTML = Mission;\nMateriaux.forEach(element => {\ndocument.getElementById('props').innerHTML += '<ul>' + element + ' </ul>';\n});\nconst a1 = (Prenom.charAt(0) + Nom).toLocaleLowerCase();\nconst image = document.getElementById('identity_card');\nimage.src = '../img/' + a1 + '.jpg';\n</script>\n</body>\n</html>";
        
        BufferedWriter BW = new BufferedWriter(new FileWriter(new File("OutputHTML/" + this.Subname + ".html")));
        BW.write(HTML);
        BW.close();
    }
}
