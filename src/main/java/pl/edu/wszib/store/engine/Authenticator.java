package pl.edu.wszib.store.engine;

import org.apache.commons.codec.digest.DigestUtils;
import pl.edu.wszib.store.database.UserDB;
import pl.edu.wszib.store.entity.User;

import java.util.List;

public class Authenticator {

    public static User loggedUser = null;
    private static final String seed = "Mp@eI&1LEqCJ71HQQV0N1j2zqItr4&1W7*F";

    public static void authenticate(User user, List<User> users){
        User userFromDB = UserDB.checkLogin(user.getLogin());
        if(userFromDB != null &&
                userFromDB.getPassword().equals(
                        DigestUtils.md5Hex(user.getPassword() + seed))) {
            loggedUser = userFromDB;
        }
    }

    public static String getHash(String password){
        return DigestUtils.md5Hex(password + seed);
    }
}
