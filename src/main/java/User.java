import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class User {
    public User(JSONObject userInfo){
        this.userName = userInfo.get("username").toString();
        this.skills = new ArrayList<Skill>();
        JSONArray array_skill = (JSONArray) userInfo.get("skills");
        try{
            for (int i = 0 ; i < array_skill.size();i++){
                this.skills.add(new Skill((JSONObject)array_skill.get(i)));
            }
        }catch (NullPointerException e){
            Main.print("dfdsfdsf\n");
            Main.print(e);
        }
    }
    private ArrayList<Skill> skills;
    private String userName;
    private int userOffer;

    public int getUserOffer() {
        return userOffer;
    }

    public void setUserOffer(int userOffer) {
        this.userOffer = userOffer;
    }

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
