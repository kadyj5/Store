package pl.edu.wszib.store.engine;

import org.apache.commons.codec.digest.DigestUtils;
import pl.edu.wszib.store.database.UserDB;
import pl.edu.wszib.store.entity.User;

public class Authorization {

    public static User loggedUser = null;
    private static String seed = "Mp@eI&1LEqCJ71HQQV0N1j2zqItr4&1W7*F";

    public static void authenticate(User user, UserDB userDB){
        User userFromDB = userDB.checkLogin(user.getLogin());
        if(userFromDB != null && userFromDB.getPassword().equals())
    }

    public static String getHash(String password){
        return DigestUtils.md5Hex(password + seed);
    }
}
