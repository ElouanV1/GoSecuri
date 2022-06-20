package gosecuri;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class Tools {
    public static Map<String, String> list_tools = new HashMap<String, String>();

    public Map<String, String> GetToolsList() throws IOException {
        BufferedReader b = new BufferedReader(new FileReader("target/ressources/liste.txt"));
        String strCurrentLine;
        while ((strCurrentLine = b.readLine()) != null){
            list_tools.put(strCurrentLine.split("\t")[0], strCurrentLine.split("\t")[1]);
        }
        b.close();
        return list_tools;
    }
}
