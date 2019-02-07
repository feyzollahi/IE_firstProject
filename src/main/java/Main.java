import Exceptions.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main {
    public static void print(Object object){
        java.lang.System.out.println(object);
    }
    public static void main(String[] args) throws IOException, ProjectNotFound, ProjectExist, BidNotValid, UserNotFound, UserExist {
//        URL url = Main.class.getResource("UserJson.txt");
//        print(url.getPath());
//        ArrayList<String> commands = (ArrayList<String>) Files.readAllLines(Paths.get("src/main/resources/UserJson.txt"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(java.lang.System.in));
        ArrayList<String> commands = new ArrayList<String>();
        do {
            commands.add(reader.readLine());
        }while(!commands.get(commands.size() - 1).split(" ", 2)[0].equals("auction"));
        System system = System.getSystem();
        system.setCommands(commands);
        system.doCommands();
    }
}
