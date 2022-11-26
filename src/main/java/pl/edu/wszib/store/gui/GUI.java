package pl.edu.wszib.store.gui;

import java.util.Scanner;

public class GUI {

    private static final Scanner scanner = new Scanner(System.in);
    public static int showMenu(){
        System.out.print("1. Sign up\n" +
                "2. Sign in\n" +
                "3. Exit\n\n" +
                "Choose option # ");
        return scanner.nextInt();
    }
}
