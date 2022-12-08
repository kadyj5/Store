package pl.edu.wszib.store.engine;

import pl.edu.wszib.store.database.ProductsDB;
import pl.edu.wszib.store.database.UserDB;
import pl.edu.wszib.store.entity.User;
import pl.edu.wszib.store.gui.GUI;

public class Engine {
    final ProductsDB productsDB = ProductsDB.getInstance();
    final Authenticator authenticator = Authenticator.getInstance();
    final GUI gui = GUI.getInstance();
    private static final Engine instance = new Engine();

    private Engine() {

    }
    public void start() {
        boolean isRunning = false;

        while(!isRunning) {
            switch (this.gui.showMenu()){
                // rejestracja
                case "1":
                    System.out.println("Registration process");
                    break;
                    // logowanie
                case "2":
                    this.authenticator.authenticate(this.gui.readLoginAndPassword());
                    isRunning = this.authenticator.getLoggedUser() != null;
                    if(!isRunning) {
                        System.out.println("No authorization !!");
                    }
                    break;
                    // wyjscie z systemu
                    case "3":
                    System.out.println("Bye!");
                    break;
                default:
                    System.out.println("Wrong choose !!");
                    break;

            }

        }

        while(isRunning) {
            // listowania produktow
            switch(this.gui.showUserMenu()) {
                case "1":
                    this.gui.listProducts();
                    break;
                    // kupowania
                case "2":
                    this.gui.showBuyResult(this.productsDB.buyProduct(gui.readProductID()));
                    break;
                case "3":
                    isRunning = false;
                    System.out.println("Bye!");
                    break;
                    // zmiana quantit
                case "4":
                    if(this.authenticator.getLoggedUser() != null &&
                            this.authenticator.getLoggedUser().getRole() == User.Role.ADMIN) {
                            this.productsDB.changeQuantity(gui.readProductID(), gui.readQuantity());
                        break;
                    }
                    // change role
                case "5":
                    if(this.authenticator.getLoggedUser() != null &&
                            this.authenticator.getLoggedUser().getRole() == User.Role.ADMIN) {

                        break;
                    }
                    break;
                default:
                    System.out.println("Wrong choose !!");
                    break;
            }
        }
    }

    public static Engine getInstance() {
        return instance;
    }


}
