package pl.edu.wszib.store;

import org.apache.commons.codec.digest.DigestUtils;
import pl.edu.wszib.store.engine.Authenticator;

public class AppHash {

    public static void main(String[] args) {
        String hash = DigestUtils.md5Hex("kdyjak" + Authenticator.getInstance().getSeed());
        System.out.println(hash);
    }
}
