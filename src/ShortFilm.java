import java.util.ArrayList;
import java.util.HashMap;

public class ShortFilm extends Film{

    //attributes
    private ArrayList<String> genre = new ArrayList<>();
    private String releaseDate;
    private ArrayList<String> writers = new ArrayList<>();
    public HashMap<String, String> filmHashMap = new HashMap<>();

    //getters
    public ArrayList<String> getGenre() {
        return genre;
    }
    public String getReleaseDate() {
        return releaseDate;
    }
    public ArrayList<String> getWriters() {
        return writers;
    }

    //constructor

    public ShortFilm(String id, String title, String language, ArrayList<String> directors, String runTime,
                     String country, ArrayList<String> cast, ArrayList<String> genre, String releaseDate,
                     ArrayList<String> writers) {
        super(id, title, language, directors, runTime, country, cast);
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.writers = writers;
    }
}
