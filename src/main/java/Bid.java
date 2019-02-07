import Exceptions.ProjectNotFound;
import Exceptions.UserNotFound;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class Bid {
    private User biddingUser;
    private Project project;
    private Long bidAmount;
    public Bid(JSONObject bid_data) throws ProjectNotFound, UserNotFound {
        System system = System.getSystem();
        this.biddingUser = system.getUser(bid_data.get("biddingUser").toString());
        this.project = system.getProject(bid_data.get("projectTitle").toString());
        this.bidAmount = (Long) bid_data.get("bidAmount");
    }
    public boolean isValidBid(){
        ArrayList<Skill> userSkills = this.biddingUser.getSkills();
        ArrayList<Skill> projectSkills = this.project.getSkills();
        if(this.bidAmount > this.project.getBudget())
            return false;
        for(Skill projectSkill: projectSkills){
            Skill userSkill = null;
            if((userSkill = this.biddingUser.getSkill(projectSkill.getName())) != null){
                if(userSkill.getPoints() < projectSkill.getPoints())
                    return false;
            }
            else{
                return false;
            }
        }
        return true; // means that project does not need any skill!
    }
    public User getBiddingUser() {
        return biddingUser;
    }

    public void setBiddingUser(User biddingUser) {
        this.biddingUser = biddingUser;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Long getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(Long bidAmount) {
        this.bidAmount = bidAmount;
    }

}
