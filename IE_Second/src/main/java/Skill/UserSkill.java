package Skill;

import User.User;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class UserSkill extends Skill {
    public UserSkill(JSONObject data) {
        this.setName(data.get("name").toString());
        this.tempSetEndorsedCount((Integer) data.get("endorsedCount"));

        this.endorsers = new HashMap<String, User>();
    }
    public UserSkill(String name){
        this.setName(name);
        this.endorsers = new HashMap<String, User>();
    }
    HashMap<String,User> endorsers;

    public int getEndorsedCount() {
        return this.endorsers.size();
    }
    int tempEndorsedCount;
    public void tempSetEndorsedCount(int endorsedCount) {
        this.tempEndorsedCount = tempEndorsedCount;
    }
    public int tempGetEndorsedCount(){
        return this.tempEndorsedCount;
    }

    public ArrayList<User> getEndorsers() {
        return new ArrayList<User>(this.endorsers.values());
    }

    public void setEndorsers(ArrayList<User> endorsers) {
        for(User endorser: endorsers){
            this.endorsers.put(endorser.getId(), endorser);
        }
    }

    public void addEndorser(User endorser){
        this.endorsers.put(endorser.getId(), endorser);
    }
}
