package pl.edu.wszib.store.database;

import pl.edu.wszib.store.entity.User;

import java.util.Optional;


public class UserDB {
    private User[] users = new User[2];
    private static final UserDB instance = new UserDB();

    private UserDB() {
        this.users[0] = new User("admin",
                "336284edfa1cdc721ca975e60ae6e2b0", User.Role.ADMIN);
        this.users[1] = new User("kdyjak",
                "d27a05b1e2e046b88a158948fc9160ba", User.Role.USER);

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
        User[] newUsers = new User[this.users.length + 1];
        System.arraycopy(this.users, 0, newUsers, 0, this.users.length);
        newUsers[newUsers.length - 1] = user;
        this.users = newUsers;
    }

    public static UserDB getInstance() {
        return instance;
    }

    public User[] getUsers() { return users; }
}
