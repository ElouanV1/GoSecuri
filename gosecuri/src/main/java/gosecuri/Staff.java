package gosecuri;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Staff {
    
    public static ArrayList<String> staff_List = new ArrayList<String>();

    public ArrayList<String> GetStaffList() throws IOException {
        Scanner scan = new Scanner(new File("target/ressources/staff.txt"));
        while (scan.hasNextLine()) {
            staff_List.add(scan.nextLine());
            
        }
        scan.close();
        return staff_List;
    }
}
