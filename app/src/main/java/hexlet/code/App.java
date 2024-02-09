package hexlet.code;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the game number and press Enter. \n 1. Greet \n 0. Exit \n Your choice: ");
        String gameNumber = scanner.next();

        if (gameNumber.equals("1")) {
            Cli.userGreet();
        } else {
            System.out.println("Exit was choosen");
            scanner.close();
        }
    }
}
