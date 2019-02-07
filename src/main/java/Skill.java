import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Skill {
    public Skill (JSONObject data){
        this.name = data.get("name").toString();
        this.points = (Long)data.get("points");
    }
    private String name;
    private Long points;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPoints() {
        return points;
    }

    public void setPoints(Long points) {
        this.points = points;
    }

}
