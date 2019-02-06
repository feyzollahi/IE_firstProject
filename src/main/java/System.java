
import Exceptions.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.HashMap;

public class System {
    public static void print(Object object){java.lang.System.out.println(object);}
    private static System singleInstance = null;
    private System () {
//        users  = new ArrayList<User>();
        users = new HashMap<String, User>();
        projects = new HashMap<String, Project>();
        bids = new HashMap<String, Bid>();
    }
    public static System getSystem(){
        if(singleInstance == null)
            singleInstance = new System();
        return  singleInstance;
    }
    private HashMap users;
    private HashMap projects;
    private HashMap bids;
    private ArrayList<String> commands;
    public ArrayList<String> getCommands() {
        return commands;
    }

    public void setCommands(ArrayList<String> commands) {
        this.commands = commands;
    }

    public void doCommands() throws UserExist, ProjectExist, UserNotFound, ProjectNotFound, BidExist {
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
                registerCommand(jsonObject);
            } else if (commandOrder.equals("addProject")) {
                addProjectCommand(jsonObject);
            } else if (commandOrder.equals("bid")) {
                bidCommand(jsonObject);
            } else if (commandOrder.equals("auction")) {
                auctionCommand(jsonObject);
            }
        }
    }

    private void addProjectCommand(JSONObject jsonObject) throws ProjectExist {
        Object project = projects.get(jsonObject.get("title"));
        if(project != null){
            throw new ProjectExist();
        }
        projects.put(jsonObject.get("title"), new Project(jsonObject));

    }

    private void registerCommand(JSONObject jsonObject) throws UserExist {
        Object user = users.get(jsonObject.get("username"));
        if(user != null){
            throw new UserExist();
        }
        users.put(jsonObject.get("username"), new User(jsonObject));
    }

    private void bidCommand(JSONObject jsonObject) throws UserNotFound, ProjectNotFound, BidExist {

        Bid bid = new Bid(jsonObject);
        this.addBid(bid);
    }
    public ArrayList<User> getUsers() {
        return new ArrayList<User>(users.values());
    }
    private void auctionCommand(JSONObject jsonObject){

    }
    public void setUsers(ArrayList<User> users) {

        for(User user:users){
            this.users.put(user.getUserName(), user);
        }
    }

    private void addProject(Project project) throws ProjectExist {
        Object project1 = this.projects.get(project.getTitle());
        if(project1 != null){
            throw new ProjectExist();
        }
        this.projects.put(project.getTitle(),project);
    }

    private void addUser(User user) throws UserExist {
        Object user1 = this.users.get(user.getUserName());
        if(user1 != null){
            throw new UserExist();
        }
        this.users.put(user.getUserName(), user);
    }

    private void addBid(Bid bid) throws BidExist {
        Object bid1 = this.bids.get(bid.getBiddingUser().getUserName() + "_" + bid.getProject().getTitle());
        if(bid1 != null){
            throw new BidExist();
        }
        this.bids.put(bid.getBiddingUser().getUserName() + "_" + bid.getProject().getTitle(), bid);
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
    public static Project getProject(String projectTitle) throws ProjectNotFound {
        System system = System.getSystem();

        Object project = system.projects.get(projectTitle);
        if(project == null){
            throw new ProjectNotFound();
        }
        return (Project) project;
    }
    public void setProjects(ArrayList<Project> projects)
    {
        for(Project project:projects)
            this.projects.put(project.getTitle(), project);
    }

    public ArrayList<Bid> getBids() {
        return new ArrayList<Bid>(bids.values());
    }

    public void setBids(ArrayList<Bid> bids) {

        for(Bid bid:bids)
            this.bids.put(bid.getBiddingUser().getUserName() + "_" + bid.getProject().getTitle(), bid);
    }

    public Bid getBid(String key) throws BidNotFound {
        System system = System.getSystem();

        Object bid = system.bids.get(key);
        if(bid == null){
            throw new BidNotFound();
        }
        return (Bid) bid;
    }

}
