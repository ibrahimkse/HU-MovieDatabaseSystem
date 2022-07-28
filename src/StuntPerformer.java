import java.util.ArrayList;

public class StuntPerformer extends Performer{

    //attributes
    private String height;
    private ArrayList<String> realActorsIds = new ArrayList<>();

    //getters
    public String getHeight() {
        return height;
    }
    public ArrayList<String> getRealActorsIds() {
        return realActorsIds;
    }

    //constructor

    public StuntPerformer(String id, String name, String surName, String country, String height,
                          ArrayList<String> realActorsIds) {
        super(id, name, surName, country);
        this.height = height;
        this.realActorsIds = realActorsIds;
    }
}
