package Skill;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Skill {
    public Skill(JSONObject jsonObj){
        this.name = (String) jsonObj.get("name");
    }
    public Skill(){

    }
    private String name;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
