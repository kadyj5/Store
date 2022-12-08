package pl.edu.wszib.store.database;

import pl.edu.wszib.store.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserDB {
    private final User[] users = new User[10];
    private static final UserDB instance = new UserDB();

    private UserDB() {
        this.users[0] = new User("admin",
                "336284edfa1cdc721ca975e60ae6e2b0", User.Role.ADMIN);
    }

    public User findByLogin(String login) {
        for(User user : this.users) {
            if(user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }

    public static UserDB getInstance() {
        return instance;
    }
}
