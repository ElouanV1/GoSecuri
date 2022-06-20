package gosecuri;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
        
        //System.out.println( "Hello World!" ); 
        Tools Tools = new Tools();
        Staff Staff = new Staff();

        Map<String, String> list_tools = Tools.GetToolsList();
        ArrayList<String> staff_List = Staff.GetStaffList();

       for (String a : staff_List) {
            Agent Agent = new Agent();
            Agent.GetAgentInfos(a, list_tools);
            Agent.WriteHTML();
       }
    }
}