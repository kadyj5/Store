package pl.edu.wszib.store.gui;

import org.apache.commons.codec.digest.DigestUtils;
import pl.edu.wszib.store.database.ProductsDB;
import pl.edu.wszib.store.database.UserDB;
import pl.edu.wszib.store.engine.Authenticator;
import pl.edu.wszib.store.entity.Product;
import pl.edu.wszib.store.entity.User;

import java.util.Scanner;

public class GUI {
    private final Scanner scanner = new Scanner(System.in);
    final Authenticator authenticator = Authenticator.getInstance();
    final ProductsDB productDB = ProductsDB.getInstance();
    final UserDB userDB = UserDB.getInstance();
    private static final GUI instance = new GUI();

    private GUI() {
    }

    public String showMenu() {
        System.out.println("1. Sign in");
        System.out.println("2. log in");
        System.out.println("3. Exit");
        return this.scanner.nextLine();
    }

    public String showUserMenu(){
        System.out.println("1. List products");
        System.out.println("2. Buy products");
        System.out.println("3. Log out");
        if (this.authenticator.getLoggedUser() != null &&
                this.authenticator.getLoggedUser().getRole() == User.Role.ADMIN) {
            System.out.println("4. Change quantity");
            System.out.println("5. Change role of user");
            System.out.println("6. List users");
        }
        return this.scanner.nextLine();
    }

    public void showBuyResult(boolean result){
        if(result){
            System.out.println("Buying completed successfully");
        } else {
            System.out.println("Product does not exist or is sold out");
        }
    }

    public void showRoleChangeResult(boolean result){
        if(result){
            System.out.println("User upgraded to ADMIN");
        } else {
            System.out.println("No such user");
        }
    }

    public void showQuantityChangeResult(boolean result){
        if(result){
            System.out.println("Quantity updated");
        } else {
            System.out.println("No such product");
        }
    }

    public void listUsers(){
        for(User user : this.userDB.getUsers()){
            System.out.println(user);
        }
    }
    public void listProducts() {
        for (Product product : this.productDB.getProducts()){
            System.out.println(product);
        }
    }
    public String readLogin(){
        System.out.println("Choose login");
        return this.scanner.nextLine();
    }
    public String readPassword(){
        System.out.println("Choose password");
        return this.scanner.nextLine();
    }
    public int readProductID(){
        listProducts();
        System.out.println("Choose ID");
        return Integer.parseInt(this.scanner.nextLine());
    }
    public int readQuantity(){
        System.out.println("How many do you want to add?");
        return Integer.parseInt(this.scanner.nextLine());
    }

    public User readLoginAndPassword() {
        User user = new User();
        System.out.println("Login:");
        user.setLogin(this.scanner.nextLine());
        System.out.println("Password:");
        user.setPassword(this.scanner.nextLine());
        return user;
    }

    public User readNewUser(){
        String login, password;
        do{
            login = readLogin();
            if(this.userDB.findByLogin(login) != null){
                System.out.println("This login is already used");
            }
        }while(this.userDB.findByLogin(login) != null);
        password = readPassword();
        password = DigestUtils.md5Hex(password + Authenticator.getInstance().getSeed());
        return new User(login,password, User.Role.USER);
    }


    public static GUI getInstance() {
        return instance;
    }
}
