package pl.edu.wszib.store.gui;

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
        // making sure that user put legal option:
        chosnenOption = scanner.nextInt();

        // getting rid of rest input that is not a number:
        scanner.nextLine();

        if(chosnenOption >= 1 && chosnenOption <=3) {
            return chosnenOption;
        } else {
            throw new IllegalStateException("Unexpected value: " + chosnenOption);
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
        return user;
    }

    public static void logging(){
        System.out.println("Hello again!");
        System.out.println("Login:");
        String login = scanner.nextLine();



    }
}
