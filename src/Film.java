import java.util.ArrayList;
import java.util.HashMap;

public class Film {
    public Film() {
    }
    //attributes
    private String id;
    private String title;
    private String language;
    private ArrayList<String> directors = new ArrayList<>();
    private String runTime;
    private String country;
    private ArrayList<String> cast = new ArrayList<>();

    //getters
    public String getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getLanguage() {
        return language;
    }
    public ArrayList<String> getDirectors() {
        return directors;
    }
    public String getRunTime() {
        return runTime;
    }
    public String getCountry() {
        return country;
    }
    public ArrayList<String> getCast() {
        return cast;
    }

    //constructor

    public Film(String id, String title, String language,
                ArrayList<String> directors, String runTime, String country, ArrayList<String> cast) {
        this.id = id;
        this.title = title;
        this.language = language;
        this.directors = directors;
        this.runTime = runTime;
        this.country = country;
        this.cast = cast;
    }
}
