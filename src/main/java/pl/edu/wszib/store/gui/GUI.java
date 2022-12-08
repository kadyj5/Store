package pl.edu.wszib.store.gui;

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
    private static final GUI instance = new GUI();

    private GUI() {
    }

    public String showMenu() {
        System.out.println("1. Sign in");
        System.out.println("2. log in");
        System.out.println("3. Exit");
        String choice;
        do{
            choice = scanner.nextLine();
        }while(choice == "1" || choice == "2" || choice == "3");
        return choice;
    }

    public String showUserMenu(){
        System.out.println("1. List products");
        System.out.println("2. Buy products");
        System.out.println("3. Log out");
        if (this.authenticator.getLoggedUser() != null &&
                this.authenticator.getLoggedUser().getRole() == User.Role.ADMIN) {
            System.out.println("4. Change quantity");
            System.out.println("5. Change role of user");
        }
        return this.scanner.nextLine();
    }


    public void listProducts() {
        for (Product product : this.productDB.getProducts()){
            System.out.println(product);
        }
    }

    public int readProductID(){
        listProducts();
        System.out.println("Choose ID");
        return Integer.parseInt(this.scanner.nextLine());
    }

    public void showBuyResult(boolean result){
        if(result){
            System.out.println("Product is bought");
        } else {
            System.out.println("Product does not exist or is sold out");
        }
    }

    public void changeRole(){

    }

    public void changeQuantity(){
        listProducts();
        System.out.print("Which product you want to add? Choose by product ID: ");
        int productID = Integer.parseInt(this.scanner.nextLine());
        for (Product product: this.productDB.getProducts()) {
            if(productID == product.getProductID()){
                System.out.println("Product founded");
                int addQuantity;
                do{
                    System.out.println("How many entities do you want to add? ");
                    addQuantity = Integer.parseInt(this.scanner.nextLine());
                }while(addQuantity < 0);

            }
            break;
        }




    }


    public User readLoginAndPassword() {
        User user = new User();
        System.out.println("Login:");
        user.setLogin(this.scanner.nextLine());
        System.out.println("Password:");
        user.setPassword(this.scanner.nextLine());
        return user;
    }


    public static GUI getInstance() {
        return instance;
    }
}
