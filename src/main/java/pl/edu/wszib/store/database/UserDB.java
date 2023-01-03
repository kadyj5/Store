package pl.edu.wszib.store.database;

import pl.edu.wszib.store.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;


public class UserDB {
    List<User> users = new ArrayList<>();
    private static final UserDB instance = new UserDB();

    private UserDB() {
        this.users.add(new User("admin",
                "336284edfa1cdc721ca975e60ae6e2b0", User.Role.ADMIN));
        this.users.add(new User("kdyjak",
                "d27a05b1e2e046b88a158948fc9160ba", User.Role.USER));
    }

    public Optional <User> findByLogin(String login) {
        Stream<User> userStream = this.users.stream();
        Optional<User> optionalUser = userStream.filter(user -> user.getLogin()
                        .equals(login))
                        .findFirst();
        if(optionalUser.isPresent()) return optionalUser;
        else return Optional.empty();

    }

    public boolean changeRole(String login){
        Stream<User> userStream = this.users.stream();
        Optional<User> optionalUser = userStream.filter(user -> login.equals(user.getLogin()))
                .filter(user -> user.getRole() == User.Role.USER)
                .findFirst();
        if(optionalUser.isPresent()) {
            User user = this.users.get(this.users.indexOf(optionalUser.get()));
            user.setRole(User.Role.ADMIN);
            return true;
        } else {
            return false;
        }
    }

    public void addUser(User user){
        this.users.add(user);
    }

    public static UserDB getInstance() {
        return instance;
    }

    public List<User> getUsers() { return users; }
}
