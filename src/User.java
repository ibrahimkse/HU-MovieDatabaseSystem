import java.io.File;
import java.util.HashMap;

public class User extends Person{
    //attributes
    public HashMap<String, String> userHashMap = new HashMap<>();

    //getter
    public HashMap<String, String> getUserHashMap() {
        return userHashMap;
    }

    //constructor
    public User(String id, String name, String surName, String country) {
        super(id, name, surName, country);
    }

    //method for check if rated
    public boolean isEarlierRated(User user, String filmId){
        return user.userHashMap.containsKey(filmId);
    }

    //method for adding rate to HashMap
    public void addRateToUserHashMap(User user, String filmId, String rating){
            user.userHashMap.put(filmId, rating);
    }
}
