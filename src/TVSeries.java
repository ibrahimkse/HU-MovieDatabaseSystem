import java.util.ArrayList;
import java.util.HashMap;

public class TVSeries extends Film{

    //attributes
    private ArrayList<String> genre = new ArrayList<>();
    private ArrayList<String> writers = new ArrayList<>();
    private String startDate;
    private String endDate;
    private String numberOfSeasons;
    private String numberOfEpisodes;
    public HashMap<String, String> filmHashMap = new HashMap<>();

    //getters
    public ArrayList<String> getGenre() {
        return genre;
    }
    public ArrayList<String> getWriters() {
        return writers;
    }
    public String getStartDate() {
        return startDate;
    }
    public String getEndDate() {
        return endDate;
    }
    public String getNumberOfSeasons() {
        return numberOfSeasons;
    }
    public String getNumberOfEpisodes() {
        return numberOfEpisodes;
    }

    //constructor

    public TVSeries(String id, String title, String language, ArrayList<String> directors, String runTime,
                    String country, ArrayList<String> cast, ArrayList<String> genre, ArrayList<String> writers,
                    String startDate, String endDate, String numberOfSeasons, String numberOfEpisodes) {
        super(id, title, language, directors, runTime, country, cast);
        this.genre = genre;
        this.writers = writers;
        this.startDate = startDate;
        this.endDate = endDate;
        this.numberOfSeasons = numberOfSeasons;
        this.numberOfEpisodes = numberOfEpisodes;
    }
}
