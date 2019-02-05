
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;

public class System {
    private ArrayList<User> users;
    private ArrayList<Project> projects;
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
            if (commandOrder.equals("register")) {
                registerCommand(jsonInfo);
            } else if (commandOrder.equals("addProject")) {
//                addProjectCommand(jsonInfo);
            } else if (commandOrder.equals("bid")) {
//            bidCommand(jsonInfo);
            } else if (commandOrder.equals("auction")) {
//            auctionCommand(jsonInfo);
            }
        }
    }

    public void registerCommand(String jsonInfo) {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = null;
        try {
            jsonObject = (JSONObject) parser.parse(jsonInfo);
        } catch (ParseException e) {
            e.printStackTrace();
            Main.print("jsonInfo cannot be parsed");
        }
        User user = new User(jsonObject);
        this.addUser(user);
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public void addProject(Project project) {
        this.projects.add(project);
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public void addBid(Bid bid) {
        this.bids.add(bid);
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }

    public void setProjects(ArrayList<Project> projects) {
        this.projects = projects;
    }

    public ArrayList<Bid> getBids() {
        return bids;
    }

    public void setBids(ArrayList<Bid> bids) {
        this.bids = bids;
    }
}
