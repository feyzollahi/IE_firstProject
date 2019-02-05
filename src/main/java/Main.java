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
        System system = new System();
        String commandline;
        ArrayList<String> commands = new ArrayList<String>();
        URL url = Main.class.getResource("UserJson.txt");
        java.lang.System.out.println(url.getPath());
        String filename="UserJson.txt";
        String cwd = java.lang.System.getProperty("user.dir");
        print(cwd);
        Path pathToFile = Paths.get(filename);
        print(pathToFile.toAbsolutePath());
        commands = (ArrayList<String>) Files.readAllLines(Paths.get("src/main/resources/UserJson.txt"));
        Main.print(commands);
        for(String command:  commands){
            Main.doCommand(command);
        }


        java.lang.System.out.println("Working Directory = " +
                java.lang.System.getProperty("user.dir"));

        JSONParser parser = new JSONParser();
        JSONObject jsonObject = new JSONObject();
//        try {
//            jsonObject = (JSONObject) parser.parse(line);
//        } catch (ParseException e) {
//            java.lang.System.out.println("json cannot be parsed");
//            java.lang.System.out.println(line);
//            e.printStackTrace();
//        }
//        User user1 = new User(jsonObject);
    }
    private static void doCommand(String command){
        String commandOrder = command.split(" ", 2)[0];
        String jsonInfo = command.split(" ", 2)[1];
        if(commandOrder.equals("register")){
            registerCommand(jsonInfo);
        }
        else if(commandOrder.equals("addProject")){
            addProjectCommand(jsonInfo);
        }
        else if(commandOrder.equals("bid")){
//            bidCommand(jsonInfo);
        }
        else if(commandOrder.equals("auction")){
//            auctionCommand(jsonInfo);
        }

//        if(commandOrder)
    }

    private static void addProjectCommand(String jsonInfo) {
    }
    private static void registerCommand(String jsonInfo){
        JSONObject jsonObject = new JSONObject();
//        JSONParser.
//        User user
    }
}
