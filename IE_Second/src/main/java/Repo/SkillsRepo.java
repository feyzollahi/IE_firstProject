package Repo;

import Skill.Skill;

import java.util.ArrayList;

public class SkillsRepo {

    private static SkillsRepo skillsRepo = null;
    private SkillsRepo(){
        this.skills = new ArrayList<Skill>();
    }
    public static SkillsRepo getInstance(){
        if(skillsRepo == null){
            skillsRepo = new SkillsRepo();
        }
        return skillsRepo;
    }
    ArrayList<Skill> skills;


    public ArrayList<Skill> getSkills() {
        return skills;
    }

    public void setSkills(ArrayList<Skill> skills) {
        this.skills = skills;
    }

    public void addSkill(Skill skill) {
        this.skills.add(skill);
    }
}
