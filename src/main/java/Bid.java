import org.json.simple.JSONObject;

public class Bid {
    private User biddingUser;
    private Project project;
    private Long bidAmount;
    public Bid(JSONObject bid_data) {
        this.biddingUser = getUser(bid_data.get("biddingUser").toString());
        this.project = getProject(bid_data.get("projectTitle").toString());
        this.bidAmount = (Long) bid_data.get("bidAmount");
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
