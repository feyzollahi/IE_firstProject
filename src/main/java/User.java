import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class User {
    public User(JSONObject userInfo){
        this.userName = userInfo.get("username").toString();
        this.skills = new HashMap<String, Skill>();
        this.userOffer = 0;
        JSONArray array_skill = (JSONArray) userInfo.get("skills");
        try{
            for (int i = 0 ; i < array_skill.size();i++){
                this.skills.put((((JSONObject) array_skill.get(i)).get("name")).toString(),new Skill((JSONObject)array_skill.get(i)));
            }
        }catch (NullPointerException e){
            Main.print(e);
        }
    }
    private HashMap<String, Skill> skills;
    private String userName;
    private int userOffer;

    public int getUserOffer() {
        return userOffer;
    }

    public void setUserOffer(int userOffer) {
        this.userOffer = userOffer;
    }

    public ArrayList<Skill> getSkills() {
        return new ArrayList<Skill>(skills.values());
    }

    public void addSkill(Skill skill){
        this.skills.put(skill.getName(), skill);
    }

    public Skill getSkill(String skillName){
        return this.skills.get(skillName);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
