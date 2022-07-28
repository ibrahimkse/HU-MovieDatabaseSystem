public class Director extends Artist {

    //attributes
    private String agent;

    //getters
    public String getAgent() {
        return agent;
    }

    //constructor
    public Director(String id, String name, String surName, String country, String agent) {
        super(id, name, surName, country);
        this.agent = agent;
    }
}
