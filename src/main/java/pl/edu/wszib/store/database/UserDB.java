package pl.edu.wszib.store.database;

import pl.edu.wszib.store.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class UserDB {
//    private User[] users = new User[2];
    List<User> users = new ArrayList<>();
    private static final UserDB instance = new UserDB();

    private UserDB() {
        this.users.add(new User("admin",
                "336284edfa1cdc721ca975e60ae6e2b0", User.Role.ADMIN));
        this.users.add(new User("kdyjak",
                "d27a05b1e2e046b88a158948fc9160ba", User.Role.USER));
    }

    public Optional <User> findByLogin(String login) {
        for(User user : this.users) {
            if(user.getLogin().equals(login)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    public boolean changeRole(String login){
        for(User user : this.users){
            if(login.equals(user.getLogin())){
                if(user.getRole() == User.Role.USER) { user.setRole(User.Role.ADMIN); }
                return true;
            }
        }
        return false;
    }

    public void addUser(User user){
        this.users.add(user);
//        this.users = newUsers;
    }

    public static UserDB getInstance() {
        return instance;
    }

    public List<User> getUsers() { return users; }
}
