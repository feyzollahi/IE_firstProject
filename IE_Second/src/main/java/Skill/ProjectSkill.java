package Skill;

import org.json.simple.JSONObject;

public class ProjectSkill extends Skill {
    public ProjectSkill(JSONObject skill){
        this.setName((String) skill.get("name"));
        this.point = (Long) skill.get("point");
    }
    private long point;

    public long getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
