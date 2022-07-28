public class Writer extends Artist{

    //attributes
    private String writingStyle;

    //getters
    public String getWritingStyle() {
        return writingStyle;
    }

    //constructor
    public Writer(String id, String name, String surName, String country, String writingStyle) {
        super(id, name, surName, country);
        this.writingStyle = writingStyle;
    }
}
