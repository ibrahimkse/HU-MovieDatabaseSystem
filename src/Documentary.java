import java.util.ArrayList;
import java.util.HashMap;

public class Documentary extends Film{

    //attributes
    private String releaseDate;
    public HashMap<String, String> filmHashMap = new HashMap<>();

    //getters
    public String getReleaseDate() {
        return releaseDate;
    }

    //constructor
    public Documentary(String id, String title, String language, ArrayList<String> directors, String runTime,
                       String country, ArrayList<String> cast, String releaseDate) {
        super(id, title, language, directors, runTime, country, cast);
        this.releaseDate = releaseDate;
    }
}
