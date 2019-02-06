
import Exceptions.UserNotFound;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class System {
    public static void print(Object object){java.lang.System.out.println(object);}
    private static System singleInstance = null;
    private System () {
//        users  = new ArrayList<User>();
        users = new HashMap<String, User>();
        projects = new HashMap<String, Project>();
        bids = new ArrayList<Bid>();
    }
    public static System getSystem(){
        if(singleInstance == null)
            singleInstance = new System();
        return  singleInstance;
    }
    private HashMap users;
    private HashMap projects;
    private ArrayList<Bid> bids;
    private ArrayList<String> commands;
    public ArrayList<String> getCommands() {
        return commands;
    }

    public void setCommands(ArrayList<String> commands) {
        this.commands = commands;
    }

    public void doCommands() {
        for (String command : commands) {
            String commandOrder = command.split(" ", 2)[0];
            String jsonInfo = command.split(" ", 2)[1];
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = new JSONObject();
            try{
                jsonObject = (JSONObject) parser.parse(jsonInfo);
            }catch (ParseException pe) {
                print("position: " + pe.getPosition());
                print(pe);
            }
            if (commandOrder.equals("register")) {
                User user = new User(jsonObject);
                users.put(user.getUserName(), user);
//                registerCommand(jsonInfo);
            } else if (commandOrder.equals("addProject")) {
//                addProjectCommand(jsonInfo);
            } else if (commandOrder.equals("bid")) {
//            bidCommand(jsonInfo);
            } else if (commandOrder.equals("auction")) {
//            auctionCommand(jsonInfo);
            }
        }
    }

    private static void registerCommand(String jsonInfo){

        JSONParser parser = new JSONParser();
        try{
            JSONObject jsonObject = (JSONObject) parser.parse(jsonInfo);
            JSONArray jarr = new JSONArray();
//            jarr = (JSONArray) jsonInfo ;
            print("The 2nd element of array");
            print(jsonObject.get("username"));
//            print(array.get(1));
        }catch(ParseException pe) {
            print("position: " + pe.getPosition());
            print(pe);
        }
    }

    public ArrayList<User> getUsers() {
        return new ArrayList<User>(users.values());
    }

    public void setUsers(ArrayList<User> users) {

        for(User user:users){
            this.users.put(user.getUserName(), user);
        }
    }

    public void addProject(Project project) {
        this.projects.put(project.getTitle(),project);
    }

    public void addUser(User user) {
        this.users.put(user.getUserName(), user);
    }

    public void addBid(Bid bid) {
        this.bids.add(bid);
    }

    public ArrayList<Project> getProjects() {
        return new ArrayList<Project>(projects.values());
    }
    public static User getUser(String userName) throws UserNotFound {
        System system = System.getSystem();
        Object user =  system.users.get(userName);
        if(user == null){
            throw new UserNotFound();
        }
        return (User) user;
    }
    public static Project getProject(String ProjectTitle){
        System system = System.getSystem();

        Object project = project.
    }
    public void setProjects(ArrayList<Project> projects)
    {
        for(Project project:projects)
            this.projects.put(project.getTitle(), project);
    }

    public ArrayList<Bid> getBids() {
        return bids;
    }

    public void setBids(ArrayList<Bid> bids) {
        this.bids = bids;
    }
}
