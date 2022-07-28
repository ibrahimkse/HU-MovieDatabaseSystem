public class Actor extends Performer{

    //attributes
    private String height;

    //getters
    public String getHeight() {
        return height;
    }

    //constructor

    public Actor(String id, String name, String surName, String country, String height) {
        super(id, name, surName, country);
        this.height = height;
    }
}
