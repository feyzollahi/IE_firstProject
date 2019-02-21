package Project;

import Bid.Bid;
import Skill.ProjectSkill;
import User.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class Project {

    public Project(JSONObject project_data) {
        this.skills = new HashMap<String, ProjectSkill>();
        this.title = project_data.get("title").toString();
        JSONArray array_skill = (JSONArray) project_data.get("skills");
        for (int i = 0; i < array_skill.size(); i++) {
            this.skills.put((((JSONObject) array_skill.get(i)).get("name")).toString(), new ProjectSkill((JSONObject) array_skill.get(i)));
        }
        this.budget = (Long) project_data.get("budget");
        this.id = (String) project_data.get("id");
        this.deadline = (Long) project_data.get("deadline");
        this.description = (String) project_data.get("description");

    }

    private HashMap<String, ProjectSkill> skills;
    private Long budget;
    private String title;
    private String id;
    private String description;
    private long deadline;
    private HashMap<String, Bid> bids;
    private User winnerUser;

    public void addBid(Bid bid) {
        this.bids.put(bid.getBiddingUser().getId(), bid);
    }

    public Bid getBid(String userId) {
        return bids.get(userId);
    }

    public User getWinnerUser() {
        return winnerUser;
    }

    public void setWinnerUser(User winnerUser) {
        this.winnerUser = winnerUser;
    }

    public void setSkills(HashMap<String, ProjectSkill> skills) {
        this.skills = skills;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getDeadline() {
        return deadline;
    }

    public void setDeadline(long deadline) {
        this.deadline = deadline;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void addSkill(ProjectSkill skill) {
        this.skills.put(skill.getName(), skill);
    }

    public ProjectSkill getSkill(String skillName) {
        return this.skills.get(skillName);
    }

    public ArrayList<ProjectSkill> getSkills() {
        return new ArrayList<ProjectSkill>(skills.values());
    }

    public Long getBudget() {
        return budget;
    }

    public void setBudget(Long budget) {
        this.budget = budget;
    }
}
