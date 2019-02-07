import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class Project {

    public Project(JSONObject project_data) {
        this.skills = new HashMap<String, Skill>();
        this.title = project_data.get("title").toString();
        JSONArray array_skill = (JSONArray) project_data.get("skills");
        for (int i = 0 ; i < array_skill.size();i++){
            this.skills.put((((JSONObject) array_skill.get(i)).get("name")).toString(),new Skill((JSONObject)array_skill.get(i)));
        }
        this.budget = (Long) project_data.get("budget");
        this.jobOffer = 0;
    }

    private HashMap<String, Skill> skills;
    private Long budget;
    private String title;

    public int getJobOffer() {
        return jobOffer;
    }

    public void setJobOffer(int jobOffer) {
        this.jobOffer = jobOffer;
    }

    private int jobOffer;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void addSkill(Skill skill){
        this.skills.put(skill.getName(), skill);
    }

    public Skill getSkill(String skillName){
        return this.skills.get(skillName);
    }
    public ArrayList<Skill> getSkills() {
        return new ArrayList<Skill>(skills.values());
    }

    public Long getBudget() {
        return budget;
    }

    public void setBudget(Long budget) {
        this.budget = budget;
    }
}
