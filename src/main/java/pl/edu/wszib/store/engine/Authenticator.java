package pl.edu.wszib.store.engine;

import org.apache.commons.codec.digest.DigestUtils;
import pl.edu.wszib.store.database.UserDB;
import pl.edu.wszib.store.entity.User;


public class Authenticator {
    private final UserDB userDB = UserDB.getInstance();
    private User loggedUser = null;
    private final String seed = "Mp@eI&1LEqCJ71HQQV0N1j2zqItr4&1W7*F";
    private static final Authenticator instance = new Authenticator();
    private Authenticator() { }
    public void authenticate(User user) {
        User userFromDB = this.userDB.findByLogin(user.getLogin());
        if(userFromDB != null &&
                userFromDB.getPassword().equals(
                        DigestUtils.md5Hex(user.getPassword() + this.seed))) {
            this.loggedUser = userFromDB;
        }
    }

    public static Authenticator getInstance() {
        return instance;
    }

    public User getLoggedUser() {
        return loggedUser;
    }

    public User getUserLoggedOut() {return loggedUser = null;}

    public String getSeed() {
        return seed;
    }
}
