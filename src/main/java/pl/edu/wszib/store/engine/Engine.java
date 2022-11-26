package pl.edu.wszib.store.engine;

import pl.edu.wszib.store.database.UserDB;
import pl.edu.wszib.store.gui.GUI;

public class Engine {

    public static void start(){

        boolean isRunning =  true;

        while(isRunning){
            switch (GUI.showMenu()){
                case 1 -> {
                    UserDB.setUsers(GUI.register());
                }
                case 2 -> {
                    GUI.logging();
                }
                case 3 -> {
                    System.out.println("See you soon!");
                    isRunning = false;
                }
                default -> System.out.println("Something went wrong please try again later!");
            };
        }
    }


}
