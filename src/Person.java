public class Person {
    public Person() {
    }

    //attributes
    private String id;
    private String name;
    private String surName;
    private String country;
    //getters

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getSurName() {
        return surName;
    }
    public String getCountry() {
        return country;
    }

    //constructor

    public Person(String id, String name, String surName, String country) {
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.country = country;
    }
}
