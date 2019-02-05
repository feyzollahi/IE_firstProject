import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException {
        URL url = Main.class.getResource("UserJson.txt");
        java.lang.System.out.println(url.getPath());
        File f = new File(url.getPath());
        java.lang.System.out.println("Working Directory = " +
                java.lang.System.getProperty("user.dir"));
        BufferedReader b = null;
        try {
            b = new BufferedReader(new FileReader(f));
        } catch (FileNotFoundException e) {
            java.lang.System.out.println("s");
            e.printStackTrace();
        }
        String line = b.readLine();
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject = (JSONObject) parser.parse(line);
        } catch (ParseException e) {
            java.lang.System.out.println("json cannot be parsed");
            java.lang.System.out.println(line);
            e.printStackTrace();
        }
        User user1 = new User(jsonObject);
    }
}
