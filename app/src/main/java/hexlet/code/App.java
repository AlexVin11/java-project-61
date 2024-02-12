package hexlet.code;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the game number and press Enter. ");
        System.out.print(" 1. Greet \n 2. Even \n 3. Calc \n 0. Exit \n Your choice: ");
        int gameNumber = scanner.nextInt();

        switch (gameNumber) {
            case 1 :
                Cli.userGreet();
                break;
            case 2 :
                String name2 = Cli.userGreet();
                EvenGame.evenGame(name2);
                break;
            case 3 :
                String name3 = Cli.userGreet();
                Calc.calc(name3);
                break;
            case 0 :
                System.out.println("Exit was choosen");
                break;
            default:
                System.out.print("Unknown command.");
                break;
        }
    }
}
