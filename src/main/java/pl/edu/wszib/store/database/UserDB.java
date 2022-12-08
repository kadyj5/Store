package pl.edu.wszib.store.database;

import pl.edu.wszib.store.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserDB {

    private static List<User> users = new ArrayList<>();

    private UserDB() {
    }

    public static void setUsers(User user) {
        users.add(user);
    }

    public static User checkLogin(String login) {
        if(users.contains(login)) {
            return users.get(users.indexOf(login));
        } else {
            return null;
        }
    }

    public static List<User> getUsersDB() {
        return users;
    }
}
