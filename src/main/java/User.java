import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class User {
    public User(JSONObject userInfo){
        String userName = userInfo.get("username").toString();
        JSONArray skills = (JSONArray) userInfo.get("skills");
    }
    private ArrayList<Skill> skills;
    private String userName;

    public ArrayList<Skill> getSkills() {
        return skills;
    }

    public void setSkills(ArrayList<Skill> skills) {
        this.skills = skills;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
