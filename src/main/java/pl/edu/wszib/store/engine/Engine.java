package pl.edu.wszib.store.engine;

import pl.edu.wszib.store.database.ProductsDB;
import pl.edu.wszib.store.database.UserDB;
import pl.edu.wszib.store.entity.User;
import pl.edu.wszib.store.gui.GUI;

public class Engine {
    final ProductsDB productsDB = ProductsDB.getInstance();
    final UserDB userDB = UserDB.getInstance();
    final Authenticator authenticator = Authenticator.getInstance();
    final GUI gui = GUI.getInstance();
    private static final Engine instance = new Engine();

    private Engine() { }

    public void start() {
        boolean isRunning = true;
        boolean isLogged = false;

        while(isRunning){
            while(!isLogged && isRunning) {
                switch (this.gui.showMenu()) {
                    case "1" -> {
                        System.out.println("Registration process...");
                        this.userDB.addUser(this.gui.readNewUser());
                    }
                    case "2" -> {
                        this.authenticator.authenticate(this.gui.readLoginAndPassword());
                        isLogged = this.authenticator.getLoggedUser() != null;
                        if (!isLogged) {
                            System.out.println("No authorization !!");
                        }
                    }
                    case "3" -> {
                        isRunning = false;
                        System.out.println("Exit");
                    }
                    default -> System.out.println("Wrong choice !!");
                }

            }

            while(isLogged) {
                switch(this.gui.showUserMenu()) {
                    case "1":
                        this.gui.listProducts();
                        break;
                    case "2":
                        this.gui.showBuyResult(this.productsDB.buyProduct(gui.readProductID(), gui.readQuantity()));
                        break;
                    case "3":
                        isLogged = false;
                        System.out.println("Logged out\n");
                        break;
                    case "4":
                        if(this.authenticator.getLoggedUser() != null &&
                                this.authenticator.getLoggedUser().getRole() == User.Role.ADMIN) {
                            gui.showQuantityChangeResult(this.productsDB.changeQuantity
                                    (gui.readProductID(), gui.readQuantity()));
                        } else { System.out.println("Permission denied"); }
                        break;
                    case "5":
                        if(this.authenticator.getLoggedUser() != null &&
                                this.authenticator.getLoggedUser().getRole() == User.Role.ADMIN) {
                            gui.showRoleChangeResult(this.userDB.changeRole(gui.readLogin()));
                        } else { System.out.println("Permission denied"); }
                        break;
                    case "6":
                        if(this.authenticator.getLoggedUser() != null &&
                                this.authenticator.getLoggedUser().getRole() == User.Role.ADMIN) {
                            this.gui.listUsers();
                        } else { System.out.println("Permission denied"); }
                        break;
                    default:
                        System.out.println("Wrong choose !!");
                        break;
                }
            }
        }

    }

    public static Engine getInstance() {
        return instance;
    }


}
