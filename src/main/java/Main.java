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
    public static void main(String[] args) throws IOException {
        URL url = Main.class.getResource("UserJson.txt");
        print(url.getPath());
//        String filename="UserJson.txt";
//        String cwd = java.lang.System.getProperty("user.dir");
//        print(cwd);
//        Path pathToFile = Paths.get(filename);
//        print(pathToFile.toAbsolutePath());
        ArrayList<String> commands = (ArrayList<String>) Files.readAllLines(Paths.get("src/main/resources/UserJson.txt"));
        System system = new System(commands);
        system.doCommands();
//        Main.print(commands);
//        for(String command:  commands){
//            Main.doCommand(command);
//        }
    }
}
