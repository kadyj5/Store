package pl.edu.wszib.store.database;

import pl.edu.wszib.store.entity.User;

public class UserDB {
    private final User[] users = new User[10];
    private static final UserDB instance = new UserDB();

    private UserDB() {
        this.users[0] = new User("admin",
                "336284edfa1cdc721ca975e60ae6e2b0", User.Role.ADMIN);
        this.users[1] = new User("kdyjak",
                "d27a05b1e2e046b88a158948fc9160ba", User.Role.USER);
    }

    public User findByLogin(String login) {
        for(User user : this.users) {
            if(user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }

    public boolean changeRole(String login){
        for(User user : this.users){
            if(login.equals(user.getLogin())){
                user.setRole(User.Role.ADMIN);
                return true;
            }
        }
        return false;
    }

    public static UserDB getInstance() {
        return instance;
    }

    public User[] getUsers() { return users; }
}
