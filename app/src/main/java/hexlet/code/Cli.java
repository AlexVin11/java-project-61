package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static String userGreet() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("May i have your name? ");
            String userName = scanner.next();
            System.out.println("\nHello, " + userName + "!");
            return userName;
    }
}
