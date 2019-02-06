import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class Project {
    private String title;

    public Project(JSONObject project_data) {
        this.skills = new ArrayList<Skill>();
        this.title = project_data.get("title").toString();
        JSONArray array_skill = (JSONArray) project_data.get("skills");
        for (int i = 0 ; i < array_skill.size();i++){
            this.skills.add(new Skill ((JSONObject) array_skill.get(i)));
        }
        this.budget = (Long) project_data.get("budget");
    }

    private ArrayList<Skill> skills;
    private Long budget;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Skill> getSkills() {
        return skills;
    }

    public void setSkills(ArrayList<Skill> skills) {
        this.skills = skills;
    }

    public Long getBudget() {
        return budget;
    }

    public void setBudget(Long budget) {
        this.budget = budget;
    }
}
