package pl.edu.wszib.store.gui;

import pl.edu.wszib.store.database.UserDB;
import pl.edu.wszib.store.entity.User;

import java.util.Scanner;

public class GUI {

    private static final Scanner scanner = new Scanner(System.in);
    private static int chosnenOption;
    public static int showMenu(){
        System.out.print("""
                1. Sign up
                2. Sign in
                3. Exit
                Choose option #\s""");

        chosnenOption = scanner.nextInt();
        scanner.nextLine();

        if(chosnenOption < 1 && chosnenOption > 3) {
            throw new IllegalStateException("Unexpected value: " + chosnenOption);
        } else {
            return chosnenOption;
        }
    }

    public static User register(){
        System.out.println("Registering in process...");
        User user = new User();
        System.out.print("Choose your login:\s");
        user.setLogin(scanner.nextLine());
        System.out.print("Choose your password:\s");
        user.setPassword(scanner.nextLine());
        System.out.println("Welcome!");
        user.setRole("USER");
        return user;
    }

    public static void logging(){
        System.out.println("Hello again!");
        System.out.println("Login:");
        String login = scanner.nextLine();
        UserDB.checkLogin(login);

    }
}
