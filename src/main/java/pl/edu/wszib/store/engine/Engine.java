package pl.edu.wszib.store.engine;

import pl.edu.wszib.store.gui.GUI;

public class Engine {

    public static void start(){

        boolean isRunning =  true;

        while(isRunning){
            switch (GUI.showMenu()){
                case 1 -> System.out.println("signing up successful");
                case 2 -> System.out.println("Signing in successful ");
                case 3 -> {
                    System.out.println("See you soon!");
                    isRunning = false;
                }
                default -> System.out.println("Something went wrong please try again later!");
            };
        }
    }


}
