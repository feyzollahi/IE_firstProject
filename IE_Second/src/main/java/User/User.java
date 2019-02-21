package User;


import Skill.UserSkill;
import org.json.simple.JSONObject;

import java.util.HashMap;

public class User {
    public User(JSONObject jsonObject) {

    }
    private String bio;
    private String firstName;
    private String lastName;
    private String id;
    private String jobTitle;
    private String profilePictureURLText;
    private HashMap<String, UserSkill> skills;

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getProfilePictureURLText() {
        return profilePictureURLText;
    }

    public void setProfilePictureURLText(String profilePictureURLText) {
        this.profilePictureURLText = profilePictureURLText;
    }

    public HashMap<String, UserSkill> getSkills() {
        return skills;
    }

    public void setSkills(HashMap<String, UserSkill> skills) {
        this.skills = skills;
    }

    public void addSkill(UserSkill skill){
        this.skills.put(skill.getName(), skill);
    }
}
