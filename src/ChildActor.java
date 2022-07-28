public class ChildActor extends Performer{

    //attributes
    private String age;

    //getters
    public String getAge() {
        return age;
    }

    //constructor
    public ChildActor(String id, String name, String surName, String country, String age) {
        super(id, name, surName, country);
        this.age = age;
    }
}
