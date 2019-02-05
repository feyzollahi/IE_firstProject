import java.util.ArrayList;

public class Project {
    private String title;

    public Project(String title, ArrayList<Skill> skills, int budget) {
        this.title = title;
        this.skills = skills;
        this.budget = budget;
    }

    private ArrayList<Skill> skills;
    private int budget;

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

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }
}
